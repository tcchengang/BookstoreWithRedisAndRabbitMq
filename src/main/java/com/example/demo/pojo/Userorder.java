package com.example.demo.pojo;

import javax.persistence.*;

public class Userorder {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_userId")
    private Integer orderUserid;

    @Column(name = "order_bookId")
    private Integer orderBookid;

    @Column(name = "order_bookName")
    private String orderBookname;

    @Column(name = "order_bookNum")
    private Integer orderBooknum;

    @Column(name = "order_state")
    private Integer orderState;

    /**
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return order_userId
     */
    public Integer getOrderUserid() {
        return orderUserid;
    }

    /**
     * @param orderUserid
     */
    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    /**
     * @return order_bookId
     */
    public Integer getOrderBookid() {
        return orderBookid;
    }

    /**
     * @param orderBookid
     */
    public void setOrderBookid(Integer orderBookid) {
        this.orderBookid = orderBookid;
    }

    /**
     * @return order_bookName
     */
    public String getOrderBookname() {
        return orderBookname;
    }

    /**
     * @param orderBookname
     */
    public void setOrderBookname(String orderBookname) {
        this.orderBookname = orderBookname;
    }

    /**
     * @return order_bookNum
     */
    public Integer getOrderBooknum() {
        return orderBooknum;
    }

    /**
     * @param orderBooknum
     */
    public void setOrderBooknum(Integer orderBooknum) {
        this.orderBooknum = orderBooknum;
    }

    /**
     * @return order_state
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * @param orderState
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}