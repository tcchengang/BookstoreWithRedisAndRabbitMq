package com.example.demo.pojo;

import javax.persistence.*;

public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_money")
    private Float userMoney;

    @Column(name = "user_power")
    private Integer userPower;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_pass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return user_address
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * @param userAddress
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * @return user_money
     */
    public Float getUserMoney() {
        return userMoney;
    }

    /**
     * @param userMoney
     */
    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * @return user_power
     */
    public Integer getUserPower() {
        return userPower;
    }

    /**
     * @param userPower
     */
    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }
}