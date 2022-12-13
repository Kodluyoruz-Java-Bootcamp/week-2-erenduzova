package com.hw2.question1medium.dao;

import com.hw2.question1medium.model.Blog;
import com.hw2.question1medium.model.BlogStatus;
import com.hw2.question1medium.model.BlogTag;
import com.hw2.question1medium.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    private static ArrayList<User> users = new ArrayList<>();

    public void createUser(User user) {
        users.add(user);
    }

    public ArrayList<User> findAllUsers() {
        return users;
    }

    public void followUser(User follower, User user) {
        user.getFollowers().add(follower);
    }

    public List<Blog> getAllBlogs(User user) {
        return user.getBlogs().stream().filter(blog -> !blog.getStatus().equals(BlogStatus.DELETED)).collect(Collectors.toList());
    }

    public void addDraftToUser(Blog draft) {
        User writer = draft.getUser();
        writer.getBlogs().add(draft);
    }

    public void followBlogTag(User user, BlogTag tag) {
        user.getFollowedTags().add(tag);
    }
}
