package com.hw2.question3emlakceptepatterns.service;

import com.hw2.question3emlakceptepatterns.dao.RealtyDao;
import com.hw2.question3emlakceptepatterns.model.Realty;
import com.hw2.question3emlakceptepatterns.model.RealtyType;
import com.hw2.question3emlakceptepatterns.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class RealtyService {

    // Singleton Pattern
    private static RealtyService realtyService;
    private RealtyDao realtyDao = RealtyDao.getInstance();
    public RealtyService() {

    }

    public static RealtyService getInstance(){
        if (realtyService == null) {
            realtyService = new RealtyService();
        }
        return realtyService;
    }

    public void createRealty(Realty realty) {
        realtyDao.saveRealty(realty);
        System.out.println("createRealty : " + realty.getTitle());
    }

    public List<Realty> getAll(){
        return realtyDao.findAll();
    }

    public void printAll(List<Realty> realtList) {
        realtList.forEach(System.out::println);
    }

    public void getAllByProvince(String province) {
        System.out.println(province + " bölgesindeki ilanlar: ");
        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .forEach(System.out::println);

    }

    public List<Realty> getAllByUserName(User user){
        System.out.println(user.getName() + " adlı kullanıcının ilanları");
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .collect(Collectors.toList());
    }

    public List<Realty> getActiveRealtyByUserName(User user) {
        System.out.println(user.getName() + " adlı kullanıcının aktif ilanları");
        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .collect(Collectors.toList());

    }

}
