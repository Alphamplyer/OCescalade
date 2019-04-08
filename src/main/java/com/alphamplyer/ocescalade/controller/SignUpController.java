package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.UserService;
import com.alphamplyer.ocescalade.utils.validation.DateValidation;
import com.alphamplyer.ocescalade.utils.validation.EmailValidation;
import com.alphamplyer.ocescalade.utils.validation.NameValidation;
import com.alphamplyer.ocescalade.utils.validation.NicknameValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.text.ParseException;

@Controller
public class SignUpController {

    private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method=RequestMethod.GET)
    public String showRegister(Model model, @RequestParam(name = "vf", required = false) Boolean valid_firstName, @RequestParam(name = "vl", required = false) Boolean valid_lastName,
                               @RequestParam(name = "vn", required = false) Boolean valid_nickname, @RequestParam(name = "ve", required = false) Boolean valid_email,
                               @RequestParam(name = "vp", required = false) Boolean valid_passwd, @RequestParam(name = "vb", required = false) Boolean valid_birthdate,
                               @RequestParam(name = "fn", required=false) String firstName, @RequestParam(name = "ln", required=false) String lastName,
                               @RequestParam(name = "em", required=false) String email, @RequestParam(name = "ni", required=false) String nickname,
                               @RequestParam(name = "bi", required=false) String birthdate, @RequestParam(name = "fa", required=false) Boolean failed) {

        if (valid_firstName != null)
            model.addAttribute("valid_firstName", valid_firstName);
        if (valid_lastName != null)
            model.addAttribute("valid_lastName", valid_lastName);
        if (valid_nickname != null)
            model.addAttribute("valid_nickname", valid_nickname);
        if (valid_email != null)
            model.addAttribute("valid_email", valid_email);
        if (valid_passwd != null)
            model.addAttribute("valid_passwd", valid_passwd);
        if (valid_birthdate != null)
            model.addAttribute("valid_birthdate", valid_birthdate);

        if (firstName != null)
            model.addAttribute("firstName", firstName);
        if (lastName != null)
            model.addAttribute("lastName", lastName);
        if (nickname != null)
            model.addAttribute("nickname", nickname);
        if (email != null)
            model.addAttribute("email", email);
        if (birthdate != null)
            model.addAttribute("birthdate", birthdate);
        if (failed != null)
            model.addAttribute("failed", failed);

        return "signup";
    }

    @RequestMapping(value = "/signup_process", method = RequestMethod.POST)
    public String addUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String nickname, @RequestParam String birthdate, @RequestParam String email, @RequestParam String Passwd, @RequestParam String ComfirmPasswd, RedirectAttributes redirectAttributes) {


        boolean valid_email = new EmailValidation().valid(email);
        boolean valid_firstName = new NameValidation().valid(firstName);
        boolean valid_lastName = new NameValidation().valid(lastName);
        boolean valid_nickname = new NicknameValidation().valid(nickname);
        boolean valid_birthdate = new DateValidation().valid(birthdate);
        boolean valid_passwd = false;

        if (Passwd != null && ComfirmPasswd != null && Passwd.length() > 0)
            valid_passwd = Passwd.equals(ComfirmPasswd);


        Date date = DateValidation.convertStringToTimestamp(birthdate);


        if (date == null) {
            valid_birthdate = false;
        }

        if (valid_email || valid_firstName || valid_lastName || valid_nickname || valid_passwd || valid_birthdate) {

            if (!(valid_email && valid_firstName && valid_lastName && valid_nickname && valid_passwd && valid_birthdate)) {
                redirectAttributes.addAttribute("vf", valid_firstName);
                redirectAttributes.addAttribute("vl", valid_lastName);
                redirectAttributes.addAttribute("vn", valid_nickname);
                redirectAttributes.addAttribute("ve", valid_email);
                redirectAttributes.addAttribute("vp", valid_passwd);
                redirectAttributes.addAttribute("vb", valid_birthdate);

                redirectAttributes.addAttribute("fn", firstName);
                redirectAttributes.addAttribute("ln", lastName);
                redirectAttributes.addAttribute("em", email);
                redirectAttributes.addAttribute("ni", nickname);
                redirectAttributes.addAttribute("bi", birthdate);

                return "redirect:signup";
            }
            else {
                redirectAttributes.addAttribute("fa", false);
            }
        }
        else {
            redirectAttributes.addAttribute("fa", true);
            return "redirect:signup";
        }

        User user = new User();

        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setNickname(nickname);
        user.setBirthday(date);
        user.setMail(email);
        user.setPassword(Passwd);

        this.userService.register(user);

        return "redirect:index";
    }
}
