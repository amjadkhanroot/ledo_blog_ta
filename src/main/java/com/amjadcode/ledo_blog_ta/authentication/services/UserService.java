package com.amjadcode.ledo_blog_ta.authentication.services;


import com.amjadcode.ledo_blog_ta.authentication.models.EGender;
import com.amjadcode.ledo_blog_ta.authentication.models.User;
import com.amjadcode.ledo_blog_ta.authentication.repositories.UserRepository;
import com.amjadcode.ledo_blog_ta.commons.CommonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByActiveTrue();
    }


    public List<User> insertRandomUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i<10; i++){
            users.add(new User(0L, CommonMethodService.generateUsername(1),CommonMethodService.generateUsername(1)+"@gmail.com", EGender.MALE, passwordEncoder.encode("password"), true, new ArrayList<>()));
        }
        return userRepository.saveAll(users);
    }


}
