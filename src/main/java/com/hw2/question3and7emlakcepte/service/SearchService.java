package com.hw2.question3and7emlakcepte.service;

import com.hw2.question3and7emlakcepte.dao.RealtyDao;
import com.hw2.question3and7emlakcepte.dao.SearchDao;
import com.hw2.question3and7emlakcepte.model.Realty;
import com.hw2.question3and7emlakcepte.model.Search;
import com.hw2.question3and7emlakcepte.model.User;
import com.hw2.question3and7emlakcepte.model.enums.RealtyKind;
import com.hw2.question3and7emlakcepte.model.enums.RealtyType;
import com.hw2.question3and7emlakcepte.model.enums.SearchType;

import java.util.List;

public class SearchService {

    // Singleton Pattern
    private static SearchService searchService;
    private RealtyDao realtyDao = RealtyDao.getInstance();
    private SearchDao searchDao = SearchDao.getInstance();

    private SearchService() {

    }

    public static SearchService getInstance() {
        if (searchService == null) {
            searchService = new SearchService();
        }
        return searchService;
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public void getAllByProvince(String province) {
        System.out.println(province + " ilindeki ilanlar: ");
        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .forEach(System.out::println);

    }

    public void getAllByDistrict(String district) {
        System.out.println(district + " ilçesindeki ilanlar: ");
        getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district))
                .forEach(System.out::println);

    }

    public void getCountByDistrict(String district) {
        System.out.println(district + " ilçesindeki ilanlar: ");
        System.out.println(getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district)).count());
        ;

    }

    public void getCountByProvince(String province) {
        System.out.println(province + " ilindeki ilanlar: ");
        System.out.println(getAll().stream()
                .filter(realty -> realty.getProvince().equals(province)).count());
    }

    public void createSearch(Search search) {
        searchDao.addSearch(search);
    }

    public void makeSearch(Search search) {
        createSearch(search);
        if (search.getSearchType().equals(SearchType.PROVINCE)) {
            getAllByProvince(search.getSearchedWord());
        } else if (search.getSearchType().equals(SearchType.DISTRICT)) {
            getAllByDistrict(search.getSearchedWord());
        }
    }

    public void printPastSearches(User user) {
        System.out.println(user.getName() + " kullanıcısının aramaları");
        searchDao.getSearches().stream().filter(search -> search.getUser().equals(user))
                .forEach(System.out::println);
    }


    public void findCount(Search search) {
        if (search.getSearchType().equals(SearchType.PROVINCE)) {
            getCountByProvince(search.getSearchedWord());
        } else if (search.getSearchType().equals(SearchType.DISTRICT)) {
            getCountByDistrict(search.getSearchedWord());
        }
    }

    public void findSaleHouseCount(String province) {
        System.out.println(province + " ilinde bulunanan satılık konut sayısı : ");
        System.out.println(getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .filter(realty -> realty.getKind().equals(RealtyKind.HOUSE))
                .filter(realty -> realty.getType().equals(RealtyType.SALE))
                .count());
    }


    public void provinceDisplay(String province) {
        System.out.println(province + " Şehir Vitrini");
        realtyDao.findAll().stream().filter(realty -> realty.getProvince().equals(province))
                .limit(10).forEach(System.out::println);
    }
}
