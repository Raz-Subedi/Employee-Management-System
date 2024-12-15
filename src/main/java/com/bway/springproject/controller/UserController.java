package com.bway.springproject.controller;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;
import com.bway.springproject.utils.VerifyRecaptcha;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping({"/","/login"})
    public String getLogin(){

        return "LoginForm";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String reCode) throws IOException {

        if(VerifyRecaptcha.verify(reCode)){

            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            User usr = userService.userLogin(user.getEmail(),user.getPassword());

            if(usr!=null) {

                log.info("--------------login Success-----------------");

                session.setAttribute("validUser",usr);
                session.setMaxInactiveInterval(200);

                model.addAttribute("uname",usr.getFname());
                return "Home";
            }else{
                log.info("-----------------Login Failed------------------------");
                model.addAttribute("error","User Doesn't Exist!!!");
                return "LoginForm";
            }
        }
        log.info("-----------------Login Failed------------------------");
        model.addAttribute("error","Your are not Human!!!");
        return "LoginForm";
    }

    @GetMapping("/signup")
    public String getSignup(){

        return "SignupForm";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute User u){

        u.setRole("ADMIN");
        u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
        userService.userSignup(u);
        return "LoginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        log.info("----------------User Logout-------------------");
        session.invalidate();  //kills session

        return "LoginForm";
    }

    @GetMapping("/profile")
    public String profile(){

        return "Profile";
    }

}
