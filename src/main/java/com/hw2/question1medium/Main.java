package com.hw2.question1medium;

import com.hw2.question1medium.model.Blog;
import com.hw2.question1medium.model.BlogTag;
import com.hw2.question1medium.model.User;
import com.hw2.question1medium.service.BlogService;
import com.hw2.question1medium.service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
        BlogService blogService = new BlogService();

        // Create Users
        User userEren = new User("Eren", "erenduzova@gmail.com", "qwerty");
        userService.createUser(userEren);
        User userCem = new User("Cem", "cemdrmn@gmail.com", "123456");
        userService.createUser(userCem);
        User userSami = new User("Sami", "samisez@gmail.com", "qazwsxedc");
        userService.createUser(userSami);
        User userPelin = new User("Pelin", "pelarslan@gmail.com", "arspel");
        userService.createUser(userPelin);
        User userElif = new User("Elif", "elifnr@gmail.com", "142536");
        userService.createUser(userElif);

        // Create Blogs
        Blog blog1 = new Blog(1L,
                userEren,
                "Java Frameworks",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                        + "Donec sem lorem, consequat at dignissim faucibus, lobortis eget lorem. "
                        + "Maecenas rutrum orci fermentum risus luctus, eu consequat felis ornare.",
                BlogTag.JAVA);
        Blog blog2 = new Blog(2L,
                userEren,
                "Web Development With Python",
                "Nulla facilisi." +
                        " Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.",
                BlogTag.PYTHON);
        Blog blog3 = new Blog(3L,
                userCem,
                "Clean Code",
                "Morbi elit elit, dapibus nec hendrerit non," +
                        " sodales sit amet sapien. Vestibulum lorem nisi, sollicitudin eget augue id," +
                        " maximus consequat nibh.",
                BlogTag.PROGRAMMING);
        Blog blog4 = new Blog(4L,
                userSami,
                "Most Used Git Codes",
                "Quisque enim diam, aliquet et tincidunt non, venenatis quis urna. Suspendisse potenti." +
                        " Cras sit amet fringilla odio, at molestie tortor.",
                BlogTag.PROGRAMMING);
        Blog blog5 = new Blog(5L,
                userPelin,
                "Future of AI",
                "Maecenas augue mi, sollicitudin ut tellus et," +
                        " bibendum ultricies risus. Maecenas ut rutrum metus.",
                BlogTag.TECHNOLOGY);
        Blog blog6 = new Blog(6L,
                userElif,
                "Which Language to Start Learning Programming",
                "Integer auctor metus tortor, sit amet bibendum urna consectetur eget.",
                BlogTag.ADVICE);
        Blog blog7 = new Blog(7L,
                userCem,
                "Starting Spring",
                "Nunc vel libero sed mauris interdum mollis a at sapien." +
                        " In hac habitasse platea dictumst. Donec in lobortis ligula, in aliquet lorem.",
                BlogTag.JAVA);

        blogService.createBlog(blog1);
        blogService.createBlog(blog2);
        blogService.createBlog(blog3);
        blogService.createBlog(blog4);
        blogService.createBlog(blog5);
        blogService.createBlog(blog6);
        blogService.createBlog(blog7);

        // Set Users Blog Lists
        userService.addDraft(blog1);
        userService.addDraft(blog2);
        userService.addDraft(blog3);
        userService.addDraft(blog4);
        userService.addDraft(blog5);
        userService.addDraft(blog6);
        userService.addDraft(blog7);

        // Publish Blogs ( 3 and 5 are not published - draft )
        blogService.publish(blog1);
        blogService.publish(blog2);
        blogService.publish(blog4);
        blogService.publish(blog6);
        blogService.publish(blog7);

        // Follow users
        userService.follow(userEren, userCem);
        userService.follow(userSami, userCem);
        userService.follow(userPelin, userCem);
        userService.follow(userElif, userCem);
        userService.follow(userEren, userSami);
        userService.follow(userElif, userSami);
        userService.follow(userCem, userSami);

        // Follow Tags
        userService.followTag(userEren, BlogTag.JAVA);
        userService.followTag(userEren, BlogTag.PYTHON);
        userService.followTag(userCem, BlogTag.PROGRAMMING);
        userService.followTag(userCem, BlogTag.JAVA);
        userService.followTag(userPelin, BlogTag.TECHNOLOGY);
        userService.followTag(userElif, BlogTag.ADVICE);
        userService.followTag(userSami, BlogTag.PROGRAMMING);
        userService.followTag(userSami, BlogTag.JAVA);

        // Print All Users
        userService.printAllUsers();

        // Print Tag's blogs
        blogService.printTagBlogs(BlogTag.JAVA);

        // Print Drafts of a User
        userService.printAllDraftsOfUser(userCem);

        // Print Published Blogs of a User
        userService.printAllBlogsOfUser(userCem);

        // Delete Blog - userCem has 1 published blog we delete it and print again
        blogService.deleteBlog(7L);
        userService.printAllBlogsOfUser(userCem);
        userService.printAllUsers();
    }

}
