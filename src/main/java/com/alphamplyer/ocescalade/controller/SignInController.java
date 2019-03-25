package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/signin")
    public String LoginPage(Model model) {
        return "signin";
    }
}
