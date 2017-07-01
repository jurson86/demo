package com.abo.model;

import java.util.Date;

/**
 * Created by jiangbo on 2017/6/26.
 */

public class WeibuWeixinUser {

    private Integer id;

    private Integer userType;

    /** 微信公众号openId */
    private String openId;

    /** 微信unionId */
    private String unionId;

    private String userUid;

    private Integer sellChannel;

    private String nickName;

    private String imageUrl;

    private Integer sex;

    private Integer birthYear;

    private Integer height;

    private Float weight;

    /** 目标步数 */
    private Integer targetStepNum;

    /** 关注/非关注 1/0 */
    private Integer subscribeFlag;

    /** 关注时间 */
    private Date subscribeTime;

    /** 取消关注时间 */
    private Date unsubscribeTime;

    /**
     * app用户表主键
     */
    private Integer appUserId;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Integer getSellChannel() {
        return sellChannel;
    }

    public void setSellChannel(Integer sellChannel) {
        this.sellChannel = sellChannel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getTargetStepNum() {
        return targetStepNum;
    }

    public void setTargetStepNum(Integer targetStepNum) {
        this.targetStepNum = targetStepNum;
    }

    public Integer getSubscribeFlag() {
        return subscribeFlag;
    }

    public void setSubscribeFlag(Integer subscribeFlag) {
        this.subscribeFlag = subscribeFlag;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Date getUnsubscribeTime() {
        return unsubscribeTime;
    }

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
