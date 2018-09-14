package com.stream.chat.controller;

import com.stream.chat.entity.User;
import com.stream.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String addUser(User user, Model model){

        if (!userService.addUser(user)){
            model.addAttribute("message", "User already exist!!!");
            return "registration";
        }
        return "redirect:/login";
    }

}
