package com.hw2.question1medium.dao;

import com.hw2.question1medium.model.Blog;
import com.hw2.question1medium.model.BlogStatus;

import java.util.ArrayList;

public class BlogDao {

    private static ArrayList<Blog> blogs = new ArrayList<>();

    public ArrayList<Blog> getAllBlogs() {
        return blogs;
    }

    public void addBlog(Blog blog) {
        getAllBlogs().add(blog);
    }

    public void publishDraft(Blog draft) {
        draft.setStatus(BlogStatus.PUBLISHED);
    }

    public void removeBlog(Blog blog) {
        blog.setStatus(BlogStatus.DELETED);
    }
}
