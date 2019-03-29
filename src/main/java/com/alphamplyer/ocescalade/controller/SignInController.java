package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.Login;
import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.UserService;
import com.alphamplyer.ocescalade.utils.validation.NicknameValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SignInController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/signin")
    public String LoginPage(Model model, @RequestParam(name = "nickname", required = false) String nickname, @RequestParam(name = "in", required = false) Boolean invalid_nickame, @RequestParam(value = "ftc", required = false) Boolean failed_to_connect) {

        if (nickname != null)
            model.addAttribute("nickname");
        if (invalid_nickame != null)
            model.addAttribute("invalid_nickname", invalid_nickame);
        if (failed_to_connect != null)
            model.addAttribute("failed", failed_to_connect);

        return "signin";
    }

    @RequestMapping(value = "/signin_process", method = RequestMethod.POST)
    public String LoginProcess(Model model, @RequestParam String nickname, @RequestParam String password, RedirectAttributes redirectAttributes, HttpSession httpSession) {

        boolean valid_nickname = new NicknameValidation().valid(nickname);

        User user;

        if (valid_nickname) {
            Login login = new Login(nickname, password);
            user = this.userService.checkPassword(login);
        } else {
            redirectAttributes.addAttribute("in", true);
            return "redirect:signin";
        }

        if (user != null) {
            httpSession.setAttribute("user_data", user);
            return "redirect:index";
        } else {
            redirectAttributes.addAttribute("ftc", true);
            return "redirect:signin";
        }
    }

    @RequestMapping(value = "/signout")
    public String LoginProcess(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user_data") != null) {
            httpSession.removeAttribute("user_data");
        }

        return "redirect:index";
    }
}
