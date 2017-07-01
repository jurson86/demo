package com.abo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



/**
 * Created by jiangbo on 2017/6/26.
 */

@Repository
@Mapper
public interface WeibuPointsBillDao {

    /**
     * 计算我的积分
     * @param userId
     * @return
     */
    Integer selectMyPoints(@Param("userId")int userId);


}
