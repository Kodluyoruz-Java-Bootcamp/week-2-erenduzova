package com.hw2.question1medium.service;

import com.hw2.question1medium.dao.UserDao;
import com.hw2.question1medium.model.Blog;
import com.hw2.question1medium.model.BlogStatus;
import com.hw2.question1medium.model.BlogTag;
import com.hw2.question1medium.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private UserDao userDao = new UserDao();

    public ArrayList<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    // Print all users
    public void printAllUsers() {
        getAllUsers().forEach(System.out::println);
    }

    // Create user
    public void createUser(User user) {
        if (!(getAllUsers().contains(user))) {
            userDao.createUser(user);
        } else {
            System.out.println("User already exists");
        }
    }

    // Follow user
    public void follow(User follower, User user) {
        if (!(user.getFollowers().contains(follower))) {
            userDao.followUser(follower, user);
        } else {
            System.out.println(follower.getName() + " is already a follower of " + user.getName());
        }
    }

    public List<Blog> getAllBlogsOfUser(User user) {
        return userDao.getAllBlogs(user);
    }

    public void printAllBlogsOfUser(User user) {
        System.out.println(getAllBlogsOfUser(user)
                .stream().filter(blog -> blog.getStatus().equals(BlogStatus.PUBLISHED)).collect(Collectors.toList()));
    }

    public void addDraft(Blog draft) {
        userDao.addDraftToUser(draft);
    }

    public void printAllDraftsOfUser(User user) {
        System.out.println(getAllBlogsOfUser(user)
                .stream().filter(blog -> blog.getStatus().equals(BlogStatus.DRAFT)).collect(Collectors.toList()));
    }

    public void followTag(User user, BlogTag tag) {
        userDao.followBlogTag(user, tag);
    }
}
