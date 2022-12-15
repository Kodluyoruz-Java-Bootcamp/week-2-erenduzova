package com.hw2.question3and7emlakcepte.dao;

import com.hw2.question3and7emlakcepte.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // Singleton
    private static UserDao userDao;

    private UserDao() {

    }
    public static UserDao getInstance(){
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    private static List<User> userList = new ArrayList<>();


    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() {
        return userList;
    }

}
