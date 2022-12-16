package com.hw2.question3and7emlakcepte.service;

import com.hw2.question3and7emlakcepte.dao.UserDao;
import com.hw2.question3and7emlakcepte.model.User;

import java.util.List;

public class UserService {

    // Singleton Pattern
    private static UserService userService;

	private UserService() {

	}
    public static UserService getInstance(){
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private UserDao userDao = UserDao.getInstance();

    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Şifre en az 5 karakterli olmalı");
        } else {
            userDao.createUser(user);
        }
    }

    public List<User> getAllUser() {
        return userDao.findAllUsers();
    }

    public User getUser(User searchedUser) {
        return userDao.findAllUsers().stream().filter(user -> user.equals(searchedUser)).findFirst().orElse(null);
    }

    public void printAllUser() {
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }

    // Update password
    public void updatePassword(User user, String newPassword) {
        userDao.findAllUsers().stream()
                .filter(user1 -> user1.equals(user))
                .findFirst().ifPresent(passwordUpdateUser -> passwordUpdateUser.setPassword(newPassword));
    }

    public void printUser(User searchedUser) {
        if (getUser(searchedUser) == null) {
            System.out.println("Not a user");
        } else {
            System.out.println(getUser(searchedUser));
        }
    }

    public boolean hasMaxRealty(User searchedUser) {
        return (getUser(searchedUser).getRealtyList().size() >= 3);
    }
}
