package com.alphamplyer.ocescalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class ErrorController {

    @RequestMapping("/error")
    public String errorpage (Model model) {
        return "error";
    }
}
