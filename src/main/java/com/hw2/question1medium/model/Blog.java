package com.hw2.question1medium.model;

public class Blog {

    private Long id;
    private User user;
    private String title;
    private String body;
    private BlogStatus status = BlogStatus.DRAFT;
    private BlogTag tag;

    public Blog() {
    }

    public Blog(Long id, User user, String title, String body, BlogTag tag) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.tag = tag;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public BlogStatus getStatus() {
        return status;
    }

    public void setStatus(BlogStatus status) {
        this.status = status;
    }

    public BlogTag getTag() {
        return tag;
    }

    public void setTag(BlogTag tag) {
        this.tag = tag;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", status=" + status +
                ", tag=" + tag +
                '}';
    }
}
