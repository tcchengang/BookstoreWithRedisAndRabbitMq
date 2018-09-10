package com.example.demo.pojo;

import javax.persistence.*;

public class Store {
    @Id
    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "store_leftnum")
    private Integer storeLeftnum;

    @Column(name = "store_salednum")
    private Integer storeSalednum;

    @Column(name = "store_money")
    private Float storeMoney;

    /**
     * @return store_id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * @param storeId
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * @return book_id
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return store_leftnum
     */
    public Integer getStoreLeftnum() {
        return storeLeftnum;
    }

    /**
     * @param storeLeftnum
     */
    public void setStoreLeftnum(Integer storeLeftnum) {
        this.storeLeftnum = storeLeftnum;
    }

    /**
     * @return store_salednum
     */
    public Integer getStoreSalednum() {
        return storeSalednum;
    }

    /**
     * @param storeSalednum
     */
    public void setStoreSalednum(Integer storeSalednum) {
        this.storeSalednum = storeSalednum;
    }

    /**
     * @return store_money
     */
    public Float getStoreMoney() {
        return storeMoney;
    }

    /**
     * @param storeMoney
     */
    public void setStoreMoney(Float storeMoney) {
        this.storeMoney = storeMoney;
    }
}