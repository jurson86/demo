package com.abo.log;

import com.abo.exception.BussException;


import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = Logger.getLogger(SystemLogAspect.class);



    // Controller Around层切点
    @Pointcut("@annotation(com.abo.log.SystemControllerLog)")
    public void controllerAroundAspect() {
    }

    /**
     * 包围通知 用于拦截Controller层记录用户的操作
     * 
     * @param joinPoint 切点
     * @return
     */
    @Around("controllerAroundAspect()")
    public Object Around(ProceedingJoinPoint joinPoint) {

        try {
            Object object = joinPoint.proceed();
            LogMessageObj logMessageObj = getLogMessageObj(joinPoint);
            logMessageObj.setMethodreturn(object);
            ObjectMapper mapper = new ObjectMapper();
            logger.info(mapper.writeValueAsString(logMessageObj));
            return object;
        } catch (Throwable e) {
            Object strurl = doAfterThrowing(joinPoint, e);
            return strurl;
        }

    }

    private LogMessageObj getLogMessageObj(ProceedingJoinPoint joinPoint) throws Exception {
        LogMessageObj LogMessageObj = new LogMessageObj();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        Enumeration<?> names = request.getParameterNames();
        Map<Object, Object> map = new HashMap<Object, Object>();
        while (names.hasMoreElements()) {
            Object name = names.nextElement();
            String[] values = request.getParameterValues(name.toString());
            if (values != null && values.length > 0) {
                if (values.length > 1) {
                    map.put(name, values);
                } else {
                    map.put(name, values[0]);
                }
            }
        }

        LogMessageObj.setAgent(getagent(request));
        LogMessageObj.setIp(getIpAddr(request));
        LogMessageObj.setParam(map);
        LogMessageObj.setRequestPath(request.getServletPath());
        String classDesc = getControllerMethodDescription(joinPoint);
        LogMessageObj.setMethodDesc(classDesc);
        return LogMessageObj;
    }

    /**
     * 处理各种异常
     * 
     * @param joinPoint
     * @param e
     * @return
     */
    public Object doAfterThrowing(ProceedingJoinPoint joinPoint, Throwable e) {
        Message resultObj = new Message();
        try {
            LogMessageObj logMessageObj  = getLogMessageObj(joinPoint);
            logMessageObj.setErrorMsg(e.getMessage());
            ObjectMapper mapper = new ObjectMapper();
            logger.info(mapper.writeValueAsString(logMessageObj), e);

            if (isAjax(joinPoint)){
                if (e instanceof BussException) {
                    resultObj.setCode(((BussException)e).getCode());
                    resultObj.setMsg(e.getMessage());
                }else if(e instanceof Exception){
                    resultObj.setCode(500);
                    resultObj.setMsg(e.getMessage());
                }
            }else{
                return "/page/errorpage.html";
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            resultObj.setMsg(e1.getMessage());
        }

        return resultObj;

    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public  Boolean isAjax(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {

                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    ResponseBody responseBodyObj=method.getAnnotation(ResponseBody.class);
                    if(null != responseBodyObj){  //ajax请求
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }



    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * 
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public  String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description="";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {

                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();

                    break;
                }
            }
        }
        return description;
    }

    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public String getagent(HttpServletRequest request) {
        String s1 = request.getHeader("user-agent");
        if (s1.contains("Android")) {
            s1 = "Android移动客户端";
        } else if (s1.contains("iPhone")) {
            s1 = "iPhone移动客户端";
        } else if (s1.contains("iPad")) {
            s1 = "iPad移动客户端";
        } else {
            s1 = "其他客户端";
        }
        return s1;
    }

}
