package com.abo.service.Impl;

import com.abo.dao.WeibuPointsBillDao;
import com.abo.dao.WeibuUserDao;
import com.abo.dao.WeibuWeixinUserDao;
import com.abo.dao.WeixinPointsDao;
import com.abo.exception.BussException;
import com.abo.model.WeibuUser;
import com.abo.model.WeibuWeixinUser;
import com.abo.service.LoginServiceI;
import com.abo.service.impl.LoginService;
import com.abo.stock.Portfolio;
import com.abo.stock.StockMarket;
import com.alibaba.fastjson.JSON;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

/**
 * Created by jiangbo on 2017/6/28.
 */
@RunWith(EasyMockRunner.class)
public class LoginServiceITest {


    @Mock
    private WeibuUserDao weibuUserDao;

    @Mock
    private WeibuWeixinUserDao weibuWeixinUserDao;

    @Mock
    private WeixinPointsDao weixinPointsDao;


    @Mock
    private WeibuPointsBillDao weibuPointsBillDao;

    private  LoginService loginServiceI = new LoginService();

    @Before
    public void setUp() {
        weibuUserDao = EasyMock.createMock(WeibuUserDao.class);
        weibuWeixinUserDao = EasyMock.createMock(WeibuWeixinUserDao.class);
        weixinPointsDao = EasyMock.createMock(WeixinPointsDao.class);
        weibuPointsBillDao = EasyMock.createMock(WeibuPointsBillDao.class);
        ReflectionTestUtils.setField(loginServiceI,"weibuUserDao",weibuUserDao);
        ReflectionTestUtils.setField(loginServiceI,"weibuWeixinUserDao",weibuWeixinUserDao);
        ReflectionTestUtils.setField(loginServiceI,"weixinPointsDao",weixinPointsDao);
        ReflectionTestUtils.setField(loginServiceI,"weibuPointsBillDao",weibuPointsBillDao);

    }


    @Test
    public void doLoginTest() throws BussException {

        WeibuUser weibuUser=new WeibuUser();
        weibuUser.setId(10);
        weibuUser.setAppName("antaet");
        weibuUser.setPhone("15915438875");
        weibuUser.setPassword("123456");

        WeibuWeixinUser weibuWeixinUser = new WeibuWeixinUser();
        weibuWeixinUser.setId(10);
        weibuWeixinUser.setAppUserId(10);

        EasyMock.expect(weibuUserDao.selectUserByPhoneAndPwd("15915438875","123456","antaet")).andReturn(weibuUser);
        EasyMock.replay(weibuUserDao);
        EasyMock.expect(weibuWeixinUserDao.selectWeixinUserByAppUserId(weibuUser.getId())).andReturn(weibuWeixinUser);
        EasyMock.replay(weibuWeixinUserDao);
        EasyMock.expect(weixinPointsDao.selectMyPoints(10) ).andReturn(1000);
        EasyMock.replay(weixinPointsDao);
        EasyMock.expect(weibuPointsBillDao.selectMyPoints(10 ) ).andReturn(5000);
        EasyMock.replay(weibuPointsBillDao);
        //正常逻辑测试
        Map<String,Object> pointMap = loginServiceI.doLogin("15915438875","123456","antaet");
        Assert.assertEquals((Integer)pointMap.get("mypoint"),Integer.valueOf(6000));


    }

    @Test
    public void doLoginValid(){
        EasyMock.expect(weibuUserDao.selectUserByPhoneAndPwd("15915438875","123456","antaet")).andReturn(null).times(1);
        EasyMock.replay(weibuUserDao);
        try{
            loginServiceI.doLogin("15915438875","123456","antaet");
            Assert.fail("账户教研逻错误");
        }catch (BussException ex){
            Assert.assertEquals("用户名或者密码错误",ex.getMessage());

        }

    }





}
