package com.abo.dao;

import com.abo.model.WeibuWeixinUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jiangbo on 2017/6/26.
 */
@Repository
@Mapper
public interface WeibuWeixinUserDao {

    WeibuWeixinUser selectWeixinUserByAppUserId(@Param("appUserId") Integer appuserId);
}
