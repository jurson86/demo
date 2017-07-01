package com.abo.exception;

/**
 * Created by Administrator on 2017/6/26.
 */
public class BussException extends Exception {
    public Integer code;

    public BussException(Integer code, String msg) {
        super(msg);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
