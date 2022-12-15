package com.hw2.question3emlakceptepatterns;

import com.hw2.question3emlakceptepatterns.service.RealtyService;
import com.hw2.question3emlakceptepatterns.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private UserService userService;
    private RealtyService realtyService;

    private Map<Class, Object> beanMap = new HashMap<>();

    public Factory() {
        userService = UserService.getInstance();
        realtyService = RealtyService.getInstance();

        beanMap.put(UserService.class, userService);
        beanMap.put(RealtyService.class, realtyService);
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

}
