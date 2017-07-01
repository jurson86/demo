package com.abo.dao;

import com.abo.model.WeibuUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by jiangbo on 2017/6/26.
 */

@Repository
@Mapper
public interface WeibuUserDao {

    WeibuUser selectUserByPhoneAndPwd(String phone, String password, String appName);


}
