package com.abo.log;

import java.io.Serializable;

public class LogMessageObj implements Serializable {

  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  private Object param;

  private String errorMsg;

  private Object methodreturn;

  private String requestPath;

  private String ip;

  private String agent;

  private String methodDesc;

  private String costTime;

  public Object getParam() {
    return param;
  }

  public void setParam(Object param) {
    this.param = param;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public Object getMethodreturn() {
    return methodreturn;
  }

  public void setMethodreturn(Object methodreturn) {
    this.methodreturn = methodreturn;
  }

  public String getRequestPath() {
    return requestPath;
  }

  public void setRequestPath(String requestPath) {
    this.requestPath = requestPath;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getAgent() {
    return agent;
  }

  public void setAgent(String agent) {
    this.agent = agent;
  }

  public String getMethodDesc() {
    return methodDesc;
  }

  public void setMethodDesc(String methodDesc) {
    this.methodDesc = methodDesc;
  }

  public String getCostTime() {
    return costTime;
  }

  public void setCostTime(String costTime) {
    this.costTime = costTime;
  }

}
