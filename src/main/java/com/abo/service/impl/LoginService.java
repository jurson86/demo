package com.abo.service.impl;

import com.abo.dao.WeibuPointsBillDao;
import com.abo.dao.WeibuUserDao;
import com.abo.dao.WeibuWeixinUserDao;
import com.abo.dao.WeixinPointsDao;
import com.abo.exception.BussException;
import com.abo.model.WeibuUser;
import com.abo.model.WeibuWeixinUser;
import com.abo.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangbo on 2017/6/26.
 */
@Service
public class LoginService implements LoginServiceI {

    @Autowired
    private WeibuUserDao weibuUserDao;

    @Autowired
    private WeibuWeixinUserDao weibuWeixinUserDao;

    @Autowired
    private WeixinPointsDao weixinPointsDao;

    @Autowired
    private WeibuPointsBillDao weibuPointsBillDao;

    @Override
    public Map<String, Object> doLogin(String phone, String password, String appName) throws BussException {
        Map<String, Object> map = new HashMap<>();
        WeibuUser weibuUser = weibuUserDao.selectUserByPhoneAndPwd(phone, password, appName);
        if(null == weibuUser){
            throw new BussException(500,"用户名或者密码错误");
        }

        WeibuWeixinUser weibuWeixinUser=weibuWeixinUserDao.selectWeixinUserByAppUserId (weibuUser.getId());
        Integer weiBuWeiXinUserId=null;
        if(null != weibuWeixinUser){
            weiBuWeiXinUserId = weibuWeixinUser.getId();
        }
        Integer mypoint = getMyPointsByWxUser(weiBuWeiXinUserId, weibuUser.getId());
        map.put("mypoint",mypoint);
        return map;
    }

    public Integer getMyPointsByWxUser(Integer wxUserId, Integer appUserId) {
        int points = 0;
        if (wxUserId != null) {
            points += weixinPointsDao.selectMyPoints(wxUserId);
        }
        if (appUserId != null) {
            points += weibuPointsBillDao.selectMyPoints(appUserId);
        }
        return points;
    }


}
