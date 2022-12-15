package com.hw2.question3and7emlakcepte;

import com.hw2.question3and7emlakcepte.service.RealtyService;
import com.hw2.question3and7emlakcepte.service.SearchService;
import com.hw2.question3and7emlakcepte.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private UserService userService;
    private RealtyService realtyService;
    private SearchService searchService;

    private Map<Class, Object> beanMap = new HashMap<>();

    public Factory() {
        userService = UserService.getInstance();
        realtyService = RealtyService.getInstance();
        searchService = SearchService.getInstance();

        beanMap.put(UserService.class, userService);
        beanMap.put(RealtyService.class, realtyService);
        beanMap.put(SearchService.class, searchService);
    }

    public Object getBean(Class clas) {
        return beanMap.get(clas);
    }


    public UserService getUserService() {
        return userService;
    }

    public RealtyService getRealtyService() {
        return realtyService;
    }

    public SearchService getSearchService() {
        return searchService;
    }

}
