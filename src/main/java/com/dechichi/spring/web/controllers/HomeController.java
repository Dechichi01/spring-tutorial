package com.dechichi.spring.web.controllers;

import com.dechichi.spring.web.DAO.Offer;
import com.dechichi.spring.web.service.OffersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private OffersService offersService;

    @RequestMapping("/")
    public String showHome(Model model, Principal principal) {

        List<Offer> offers = offersService.getCurrent();

        model.addAttribute("offers", offers);

        boolean hasOffer = false;

        if(principal != null){
            hasOffer = offersService.hasOffer(principal.getName());
        }

        model.addAttribute("hasOffer", hasOffer);
        return "home";
    }

}
