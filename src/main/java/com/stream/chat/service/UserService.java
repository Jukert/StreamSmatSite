package com.stream.chat.service;

import com.stream.chat.entity.Role;
import com.stream.chat.entity.User;
import com.stream.chat.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user){

        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null)
            return false;

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return true;
    }

    public void changeUser(User user, String username, String name, String surname, String email, String number){
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setNumber(number);
        userRepo.save(user);
    }

}
