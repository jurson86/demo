package com.abo.log;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Message {

    private Integer code;

    private String msg;

    private Object data;

    public Message(){};

    public Message(String data){
        this.data=data;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
