package com.stream.chat.controller;

import com.stream.chat.entity.User;
import com.stream.chat.repo.UserRepo;
import com.stream.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/account")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Value("${upload.path}")
    private String uploadPath;

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
            @RequestParam String number,
            @RequestParam("file") MultipartFile file
            ) throws IOException {
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setNumber(number);

        if (file != null && !file.getOriginalFilename().isEmpty()){
            if (user.getAvatar() != null){
                File deleteFile = new File(uploadPath+"/" + user.getAvatar());
                if (deleteFile.exists()){
                    deleteFile.delete();
                }
            }

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdirs();


            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath+"/"+resultFilename));
            user.setAvatar(resultFilename);
        }
        userRepo.save(user);

        return "redirect:/account";
    }

}
