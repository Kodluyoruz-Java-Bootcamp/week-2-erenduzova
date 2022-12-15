package com.hw2.question3emlakceptepatterns.dao;

import com.hw2.question3emlakceptepatterns.model.Realty;

import java.util.ArrayList;
import java.util.List;

public class RealtyDao{

    // Singleton
    private static RealtyDao realtyDao;

    private RealtyDao() {

    }
    public static RealtyDao getInstance(){
        if (realtyDao == null) {
            realtyDao = new RealtyDao();
        }
        return realtyDao;
    }

    private static List<Realty> realtyList = new ArrayList<>();

    public void saveRealty(Realty realty) {
        realtyList.add(realty);
    }

    public List<Realty> findAll(){
        return realtyList;
    }

}
