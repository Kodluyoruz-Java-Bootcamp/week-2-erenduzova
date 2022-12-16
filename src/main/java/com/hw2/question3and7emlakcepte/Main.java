package com.hw2.question3and7emlakcepte;


import com.hw2.question3and7emlakcepte.model.Message;
import com.hw2.question3and7emlakcepte.model.Realty;
import com.hw2.question3and7emlakcepte.model.Search;
import com.hw2.question3and7emlakcepte.model.User;
import com.hw2.question3and7emlakcepte.model.enums.*;
import com.hw2.question3and7emlakcepte.service.RealtyService;
import com.hw2.question3and7emlakcepte.service.SearchService;
import com.hw2.question3and7emlakcepte.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
/*
        //Singleton
        UserService userService = UserService.getInstance();
        RealtyService realtyService = RealtyService.getInstance();
*/
        //Factory
        Factory factory = new Factory();
        UserService userService = (UserService) factory.getBean(UserService.class);
        RealtyService realtyService = (RealtyService) factory.getBean(RealtyService.class);
        SearchService searchService = (SearchService) factory.getBean(SearchService.class);

        User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
        User userSami = prepareUser("Sami", "sami@gmail.com", "123456");
        User userEren = prepareUser("Eren", "erend@gmail.com", "qwerty");

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

        Realty realty1 = prepareRealty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", userSami, RealtyKind.HOUSE, RealtyType.SALE, "İstanbul", "Zekeriyaköy");
        Realty realty2 = prepareRealty(124L, "Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA", userPelin, RealtyKind.APARTMENT, RealtyType.SALE, "İstanbul", "Büyükdere");
        Realty realty3 = prepareRealty(125L, "KAVAKPINAR MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI", userPelin, RealtyKind.HOUSE, RealtyType.RENT, "İstanbul", "Pendik");
        Realty realty4 = prepareRealty(126L, "ERYAMAN KİRALIK 3+1 EŞYALI YUNUS EMRE ÇAĞDAŞ EPA PUSULA'DAN", userPelin, RealtyKind.HOUSE, RealtyType.RENT, "Ankara", "Etimesgut");
        Realty realty5 = prepareRealty(127L, "Kemalpaşa Bağyurdun'da satılık kirazlık", userPelin, RealtyKind.LAND, RealtyType.SALE, "İzmir", "Kemalpaşa");

        realtyService.createRealty(realty1);
        realtyService.createRealty(realty2);
        realtyService.createRealty(realty3);
        realtyService.createRealty(realty4);
        realtyService.createRealty(realty5);


        // ----------------------
        userSami.setRealtyList(List.of(realty1));
        userPelin.setRealtyList(List.of(realty2, realty3, realty4, realty5));


        List<Realty> fovarilerim = new ArrayList<>();

        fovarilerim.add(realty3);
        userSami.setFavoriteRealtyList(fovarilerim);
        //-----------------------


        // Print all realty
        realtyService.printAll(realtyService.getAll());

        System.out.println("-----------------------------------------------");

        // Search by Province or District
        Search search1 = prepareSearch(SearchType.PROVINCE, userEren, "İstanbul");
        Search search2 = prepareSearch(SearchType.DISTRICT, userSami, "Zekeriyaköy");
        Search search3 = prepareSearch(SearchType.PROVINCE, userPelin, "Ankara");
        Search search4 = prepareSearch(SearchType.DISTRICT, userEren, "Kavakpınar");
        Search search5 = prepareSearch(SearchType.DISTRICT, userSami, "İzmir");

        searchService.makeSearch(search1);
        searchService.makeSearch(search2);
        searchService.makeSearch(search3);
        searchService.makeSearch(search4);
        searchService.makeSearch(search5);

        // Print user's past searches
        searchService.printPastSearches(userEren);

        System.out.println("-----------------------------------------------");

        System.out.println("-----------------------------------------------");
        // Find realty count
        searchService.findCount(search1);
        searchService.findCount(search3);
        searchService.findCount(search5);

        // Find istanbul ankara izmir sale house kind realty

        searchService.findSaleHouseCount("İstanbul");
        searchService.findSaleHouseCount("Ankara");
        searchService.findSaleHouseCount("İzmir");


        System.out.println("-----------------------------------------------");
        // Province 10
        searchService.provinceDisplay("İstanbul");
        searchService.provinceDisplay("Ankara");
        searchService.provinceDisplay("İzmir");

        System.out.println("-----------------------------------------------");


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
        return new User(name, email, password, UserType.INDIVIDUAL, List.of());
    }

    private static Realty prepareRealty(Long no, String title, User user, RealtyKind kind, RealtyType type, String province, String district) {
        return new Realty(no, title, user, RealtyStatus.WAITING, kind, type, province, district);
    }

    private static Search prepareSearch(SearchType searchType, User user, String searchedWord) {
        return new Search(searchType, user, searchedWord);
    }

}
