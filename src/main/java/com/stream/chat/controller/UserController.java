package com.stream.chat.controller;

import com.stream.chat.entity.User;
import com.stream.chat.repo.UserRepo;
import com.stream.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping
    public String account(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findById(((User)authentication.getPrincipal()).getId()).get();
        model.addAttribute("userSettings", user);
        return "account";
    }

    @PostMapping("/change")
    public String changed(
            @RequestParam("userId") User user,
            @RequestParam String username,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String number
            ){
        userService.changeUser(user,username,name,surname,email,number);
        return "redirect:/account";
    }

    @PostMapping
    public String changeAvatar(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        return "redirect:/account";
    }
}
