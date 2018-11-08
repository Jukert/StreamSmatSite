package com.stream.chat.service;

import com.stream.chat.entity.Role;
import com.stream.chat.entity.User;
import com.stream.chat.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Stream;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;

    @Value("${url.site.fullpath}")
    private String url;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user){

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null)
            return false;

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        if (!StringUtils.isEmpty(user.getEmail())){

            StringBuilder message = new StringBuilder();

            try(Stream<String> stream = Files.lines(Paths.get("C:\\Users\\User\\Desktop\\ChatSite\\src\\main\\resources\\static\\mail\\mail.html"),StandardCharsets.UTF_8)) {
                stream.forEach(s -> message.append(s));
            } catch (IOException e) {
                e.printStackTrace();
            }

            mailSender.send(
                    user.getEmail(),
                    "Activation code!",
                    new String(message)
            );
        }
        return true;
    }

    public boolean activateUser(String code) {
       User user = userRepo.findByActivationCode(code);

       if (user == null){
           return false;
       }

       user.setActivationCode(null);
       user.setActive(true);

       userRepo.save(user);
       return true;
    }
}
