package com.hw2.question3emlakceptepatterns.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Realty {

    private Long no;
    private String title;
    private LocalDateTime publishedDate = LocalDateTime.now();
    private User user;
    private RealtyType status;
    private String province;

    public Realty(Long no, String title, User user, RealtyType status, String province) {
        super();
        this.no = no;
        this.title = title;
        this.user = user;
        this.status = status;
        this.province = province;
    }
    public Long getNo() {
        return no;
    }
    public void setNo(Long no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public RealtyType getStatus() {
        return status;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", user=" + user
                + ", status=" + getStatus() + ", province=" + province + "]";
    }

}
