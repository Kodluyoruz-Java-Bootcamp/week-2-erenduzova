package com.hw2.question1medium.service;

import com.hw2.question1medium.dao.BlogDao;
import com.hw2.question1medium.model.Blog;
import com.hw2.question1medium.model.BlogStatus;
import com.hw2.question1medium.model.BlogTag;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BlogService {

    private BlogDao blogDao = new BlogDao();

    public ArrayList<Blog> getAllBlogs() {
        return blogDao.getAllBlogs();
    }

    public void createBlog(Blog blog) {
        if (!(getAllBlogs().contains(blog))) {
            blogDao.addBlog(blog);
        } else {
            System.out.println("Duplicate Blog!!!");
        }
    }

    public void publish(Blog draft) {
        if (draft.getStatus().equals(BlogStatus.DRAFT)) {
            blogDao.publishDraft(draft);
        } else {
            System.out.println("Already published!!!");
        }
    }

    public void printTagBlogs(BlogTag tag) {
        System.out.println(getAllBlogs().stream().
                filter(blog -> blog.getTag().equals(tag)).collect(Collectors.toList()));
    }

    public Blog getBlog(long l) {
        return getAllBlogs().stream().filter(blog -> blog.getId().equals(l)).findFirst().orElse(null);
    }

    public void deleteBlog(long l) {
        if (getBlog(l) != null) {
            blogDao.removeBlog(getBlog(l));
        } else {
            System.out.println("There is no blog with this id");
        }
    }
}
