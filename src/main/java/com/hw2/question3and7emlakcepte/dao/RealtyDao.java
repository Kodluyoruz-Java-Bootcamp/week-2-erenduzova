package com.hw2.question3and7emlakcepte.dao;

import com.hw2.question3and7emlakcepte.model.Realty;

import java.util.ArrayList;
import java.util.List;

public class RealtyDao{

    // Singleton
    private static RealtyDao realtyDao;

    public RealtyDao() {

    }

    public static RealtyDao getInstance() {
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
