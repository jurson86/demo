package com.abo.controller;

import com.abo.exception.BussException;
import com.abo.log.Message;
import com.abo.log.SystemControllerLog;
import com.abo.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by jiangbo on 2017/6/26.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginServiceI loginServiceI;

    @RequestMapping("/dologin")
    @SystemControllerLog(description = "登陆测试")
    public @ResponseBody Message doLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord, @RequestParam("appname") String appName ) throws BussException {
        Message message = new Message("Ok");
        Map<String, Object> resultMap = loginServiceI.doLogin(userName, passWord, appName);

        message.setData(resultMap);
        return message;
    }

    @RequestMapping("/tologin")
    @SystemControllerLog(description = "登陆页面测试")
    public  String toLogin(@RequestParam("username") String userName, @RequestParam("password") String passWord, @RequestParam("appname") String appName, ModelMap modelMap) throws BussException {

        Map<String, Object> resultMap = loginServiceI.doLogin(userName, passWord, appName);
        modelMap.put("result",resultMap);
        return "/page/main.html";
    }

    @RequestMapping("/errors")
    public  String testerror( ModelMap modelMap) throws BussException {

        return "/page/main.html";
    }


}
