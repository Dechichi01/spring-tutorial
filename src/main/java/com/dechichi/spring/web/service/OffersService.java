package com.dechichi.spring.web.service;

import com.dechichi.spring.web.DAO.Offer;
import com.dechichi.spring.web.DAO.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offersService")
public class OffersService {

    private OffersDAO offersDao;

    @Autowired
    public void setOffersDao(OffersDAO offersDao) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void create(Offer offer) {
        offersDao.create(offer);
    }

}