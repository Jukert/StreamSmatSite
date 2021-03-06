package com.stream.chat.controller;

import com.stream.chat.entity.User;
import com.stream.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){

        if (!userService.addUser(user)){
            model.addAttribute("message", "User already exist!!!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){

        boolean isActivated =userService.activateUser(code);

        if (isActivated){
            model.addAttribute("message", "User successfully activate");
        }else{
            model.addAttribute("message", "Activated code is not found");
        }

        return "login";
    }

}
