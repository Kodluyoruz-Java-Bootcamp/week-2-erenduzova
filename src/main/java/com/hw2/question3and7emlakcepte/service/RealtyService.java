package com.hw2.question3and7emlakcepte.service;

import com.hw2.question3and7emlakcepte.dao.RealtyDao;
import com.hw2.question3and7emlakcepte.model.Realty;
import com.hw2.question3and7emlakcepte.model.User;
import com.hw2.question3and7emlakcepte.model.enums.RealtyKind;
import com.hw2.question3and7emlakcepte.model.enums.RealtyStatus;
import com.hw2.question3and7emlakcepte.model.enums.UserType;

import java.util.List;
import java.util.stream.Collectors;

public class RealtyService {

    // Singleton Pattern
    private static RealtyService realtyService;

    private RealtyService() {

    }

    public static RealtyService getInstance(){
        if (realtyService == null) {
            realtyService = new RealtyService();
        }
        return realtyService;
    }

    private RealtyDao realtyDao = RealtyDao.getInstance();

    public void createRealty(Realty realty) {
        if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
            if (!realty.getKind().equals(RealtyKind.HOUSE)) {
                System.out.println("Individual users can have only house type realty");
                return;
            } else {
                if (realty.getUser().getRealtyList().size() >= 3) {
                    System.out.println("Individual users can have max 3 realty");
                    return;
                }
            }
        }
        realty.setStatus(RealtyStatus.ACTIVE);
        realtyDao.saveRealty(realty);
        System.out.println("createRealty : " + realty.getTitle());
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public void printAll(List<Realty> realtyList) {
        realtyList.forEach(System.out::println);
    }

    public List<Realty> getAllByUserName(User user) {
        System.out.println(user.getName() + " adlı kullanıcının ilanları");
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .collect(Collectors.toList());
    }

    public List<Realty> getActiveRealtyByUserName(User user) {
        System.out.println(user.getName() + " adlı kullanıcının aktif ilanları");
        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyStatus.ACTIVE.equals(realty.getStatus()))
                .collect(Collectors.toList());

    }

}
