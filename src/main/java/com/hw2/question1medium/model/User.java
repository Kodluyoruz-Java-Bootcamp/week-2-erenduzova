package com.hw2.question1medium.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String name;
    private String mail;
    private String password;
    private List<Blog> blogs = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private List<BlogTag> followedTags = new ArrayList<>();

    public User() {
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<BlogTag> getFollowedTags() {
        return followedTags;
    }

    public void setFollowedTags(List<BlogTag> followedTags) {
        this.followedTags = followedTags;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", blogs=" + blogs.stream().filter(blog -> !blog.getStatus().equals(BlogStatus.DELETED))
                                    .map(Blog::getId).collect(Collectors.toList()) +
                ", followers=" + followers.stream().map(User::getName).collect(Collectors.toList()) +
                ", followedTags=" + followedTags +
                '}';
    }
}
