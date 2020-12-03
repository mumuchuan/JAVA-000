package com.week07.datasource02.entity;

import java.io.Serializable;

/**
 * 用户信息表(CustomerInf)实体类
 *
 * @author makejava
 * @since 2020-12-02 20:45:08
 */
public class CustomerInf implements Serializable {
    private static final long serialVersionUID = 467031716301637251L;
    /**
     * 自增主键ID
     */
    private Integer customerInfId;
    /**
     * customer_login表的自增ID
     */
    private Integer customerId;
    /**
     * 用户真实姓名
     */
    private String customerName;
    /**
     * 证件类型：1 身份证，2 军官证，3 护照
     */
    private Integer identityCardType;
    /**
     * 证件号码
     */
    private String identityCardNo;
    /**
     * 手机号
     */
    private Integer mobilePhone;
    /**
     * 邮箱
     */
    private String customerEmail;
    /**
     * 性别
     */
    private String gender;
    /**
     * 用户积分
     */
    private Integer userPoint;
    /**
     * 注册时间
     */
    private Long registerTime;
    /**
     * 会员生日
     */
    private Long birthday;
    /**
     * 会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石
     */
    private Integer customerLevel;
    /**
     * 用户余额
     */
    private Double userMoney;
    /**
     * 最后修改时间
     */
    private Long modifiedTime;


    public Integer getCustomerInfId() {
        return customerInfId;
    }

    public void setCustomerInfId(Integer customerInfId) {
        this.customerInfId = customerInfId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getIdentityCardType() {
        return identityCardType;
    }

    public void setIdentityCardType(Integer identityCardType) {
        this.identityCardType = identityCardType;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public Integer getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Integer mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Long getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "CustomerInf{" +
                "customerInfId=" + customerInfId +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", identityCardType=" + identityCardType +
                ", identityCardNo='" + identityCardNo + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", customerEmail='" + customerEmail + '\'' +
                ", gender='" + gender + '\'' +
                ", userPoint=" + userPoint +
                ", registerTime=" + registerTime +
                ", birthday=" + birthday +
                ", customerLevel=" + customerLevel +
                ", userMoney=" + userMoney +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}