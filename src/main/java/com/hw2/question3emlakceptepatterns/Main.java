package com.hw2.question3emlakceptepatterns;


import com.hw2.question3emlakceptepatterns.model.*;
import com.hw2.question3emlakceptepatterns.service.RealtyService;
import com.hw2.question3emlakceptepatterns.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Singleton
        UserService userService = UserService.getInstance();
        RealtyService realtyService = RealtyService.getInstance();

        User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
        User userSami = prepareUser("Sami", "sami@gmail.com", "123456");
        User userEren = prepareUser("Eren", "eren_duzova@hotmail.com", "qwerty");

        // Create Users
        userService.createUser(userPelin);
        userService.createUser(userSami);
        userService.createUser(userEren);

        // Print all users
        userService.printAllUser();

        // Update password
        userService.printUser(userEren);
        userService.updatePassword(userEren, "ytrewq");
        userService.printUser(userEren);

        System.out.println("----------------------------------");

        Realty realty1 = prepareRealty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", userSami, "İstanbul");
        Realty realty2 = prepareRealty(124L, "Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA", userPelin, "İstanbul");
        Realty realty3 = prepareRealty(125L, "KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI", userPelin, "Ankara");

        realtyService.createRealty(realty1);
        realtyService.createRealty(realty2);
        realtyService.createRealty(realty3);


        // ----------------------
        realty1.setUser(userSami);
        userSami.setRealtyList(List.of(realty1, realty2));

        List<Realty> fovarilerim = new ArrayList<>();

        fovarilerim.add(realty3);
        userSami.setFavoriteRealtyList(fovarilerim);
        //-----------------------


        // Print all realty
        realtyService.printAll(realtyService.getAll());

        // Print realty by province
        realtyService.getAllByProvince("İstanbul");

        // Print user's all realty
        realtyService.printAll(realtyService.getAllByUserName(userPelin));
        realtyService.printAll(realtyService.getAllByUserName(userSami));

        // Print user's active realty
        realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

        // Create Message
        Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
                userSami);

        userSami.setMessages(List.of(message));
        userPelin.setMessages(List.of(message));

        userSami.getMessages();
    }
    private static User prepareUser(String name, String email, String password) {
        return new User(name,email,password,UserType.INDIVIDUAL,List.of());
    }
    private static Realty prepareRealty(Long no, String title, User user, String province) {
        return new Realty(no, title, user, RealtyType.ACTIVE, province);
    }

}
