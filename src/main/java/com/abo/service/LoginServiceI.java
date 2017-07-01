package com.abo.service;

import com.abo.exception.BussException;
import sun.security.util.Password;

import java.util.Map;

/**
 * Created by jiangbo on 2017/6/26.
 */
public interface LoginServiceI {

     Map<String,Object> doLogin(String username, String password, String appName) throws BussException;

}
