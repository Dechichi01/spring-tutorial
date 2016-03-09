package com.dechichi.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gabriel on 09/03/16.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLogin(){
        return "login";
    }
}
