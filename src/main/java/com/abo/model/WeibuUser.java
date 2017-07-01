package com.abo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by jiangbo on 2017/6/26.
 */
public class WeibuUser {

    /** userId */
    private Integer id;

    /** 0:不可用 1:可用 */
    private Integer enabled;

    /** app名称 */
    private String appName;

    private String userUid;

    /** 手机号码 */
    private String phone;

    /** 密码 */
    private String password;

    /** 用户类型 */
    private Integer userType;

    private String wxOpenId;

    /** 微信unionId */
    private String wxUnionId;

    private String wxUniqueIndex;

    /** 昵称 */
    private String nickName;

    /** 头像名称 */
    private String imageName;

    /** 头像地址 */
    private String imageUrl;

    /** home背景图片名称 */
    private String homeBgName;

    private String wxNickName;

    private String wxImageUrl;

    private String email;

    /** 性别 0:男 1:女 */
    private Integer sex;

    /** age */
    private Integer age;

    /** 出生年 */
    private Integer birthYear;

    /** 身高cm */
    private Integer height;

    /** 体重kg */
    private Float weight;

    private Integer targetStepNum;

    private String talk;

    private String appSessionId;

    /** 极光推送别名 */
    private String jPushAlias;

    private String userNum;

    @Deprecated
    private String qrCodeUrl;

    /** json格式url */
//    private String qrCodeUrl2;

    private String remark;

    /** 其他json字符串 */
    private String other;

    /** 用户级别 */
    private Integer userLevel;

    /** 用户指数 */
    private Integer userValue;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    private String district;

    /** 活力指数 */
    private Integer vigor;

    /** 步长 */
    private Integer stepLength;

    /** 创建圈子的上限数量 */
    private Integer createGroupMaxNum;

    /** 最后登录时间 */
    private Date lastLoginTime;

    /** 基础信息更新时间 */
    private Date infoUpdateTime;

    /** 创建时间 */
    private Date createTime;

    /**
     * 判断用户是否信息完全
     * @return
     */
    public boolean isHaveInfo() {

        if(sex != null && birthYear != null && weight != null && height != null) {
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHomeBgName() {
        return homeBgName;
    }

    public void setHomeBgName(String homeBgName) {
        this.homeBgName = homeBgName;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getWxImageUrl() {
        return wxImageUrl;
    }

    public void setWxImageUrl(String wxImageUrl) {
        this.wxImageUrl = wxImageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getWxUniqueIndex() {
        return wxUniqueIndex;
    }

    public void setWxUniqueIndex(String wxUniqueIndex) {
        this.wxUniqueIndex = wxUniqueIndex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexName() {

        if(sex == null) {
            return null;
        }
        return sex == 0 ? "男" : "女";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getAppSessionId() {
        return appSessionId;
    }

    public void setAppSessionId(String appSessionId) {
        this.appSessionId = appSessionId;
    }

    public String getjPushAlias() {
        return jPushAlias;
    }

    public void setjPushAlias(String jPushAlias) {
        this.jPushAlias = jPushAlias;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

//    public String getQrCodeUrl2() {
//        return qrCodeUrl2;
//    }
//
//    public void setQrCodeUrl2(String qrCodeUrl2) {
//        this.qrCodeUrl2 = qrCodeUrl2;
//    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserValue() {
        return userValue;
    }

    public void setUserValue(Integer userValue) {
        this.userValue = userValue;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getVigor() {
        return vigor;
    }

    public void setVigor(Integer vigor) {
        this.vigor = vigor;
    }

    public Integer getStepLength() {
        return stepLength;
    }

    public void setStepLength(Integer stepLength) {
        this.stepLength = stepLength;
    }

    public Integer getCreateGroupMaxNum() {
        return createGroupMaxNum;
    }

    public void setCreateGroupMaxNum(Integer createGroupMaxNum) {
        this.createGroupMaxNum = createGroupMaxNum;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getInfoUpdateTime() {
        return infoUpdateTime;
    }

    public void setInfoUpdateTime(Date infoUpdateTime) {
        this.infoUpdateTime = infoUpdateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

