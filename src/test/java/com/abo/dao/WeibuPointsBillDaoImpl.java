package com.abo.dao;

import com.abo.model.WeibuWeixinUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbo on 2017/6/27.
 */
@Service
public class WeibuPointsBillDaoImpl implements WeibuWeixinUserDao {
    @Override
    public WeibuWeixinUser selectWeixinUserByAppUserId(@Param("appUserId") Integer appuserId) {


        return null;
    }
}
