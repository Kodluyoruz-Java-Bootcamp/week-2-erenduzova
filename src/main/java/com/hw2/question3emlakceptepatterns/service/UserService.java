package com.hw2.question3emlakceptepatterns.service;

import com.hw2.question3emlakceptepatterns.dao.UserDao;
import com.hw2.question3emlakceptepatterns.model.User;

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
        userDao.findAllUsers().stream().filter(user -> user.equals(searchedUser)).findFirst().ifPresent(System.out::println);
    }
}
