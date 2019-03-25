package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/signup")
    public String showRegister(Model model) {



        return "signup";
    }

    @RequestMapping(value = "signup_process", method = RequestMethod.POST)
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String nickname, @RequestParam String birthdate, @RequestParam String email, @RequestParam String Passwd, @RequestParam String ComfirmPasswd) {

        User user = new User();

        this.userService.register(user);

        return "redirect:index";
    }
}
