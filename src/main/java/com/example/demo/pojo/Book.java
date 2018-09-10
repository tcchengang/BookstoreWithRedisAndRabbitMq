package com.example.demo.pojo;

import javax.persistence.*;

public class Book {
    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private Float bookPrice;

    @Column(name = "book_desc")
    private String bookDesc;

    @Column(name = "book_type")
    private String bookType;

    /**
     * @return book_id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * @return book_name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return book_price
     */
    public Float getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice
     */
    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    /**
     * @return book_desc
     */
    public String getBookDesc() {
        return bookDesc;
    }

    /**
     * @param bookDesc
     */
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    /**
     * @return book_type
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * @param bookType
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}