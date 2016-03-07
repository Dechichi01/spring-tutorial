package com.dechichi.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gabriel on 07/03/16.
 */

@Controller
public class OffersController {

    @RequestMapping("/")
    public String showHome(){

        //model.addAttribute("name", "<b>Tiffany</b>");
        return "home";
    }
}
