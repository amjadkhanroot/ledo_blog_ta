package com.amjadcode.ledo_blog_ta.authentication.controllers;

import com.amjadcode.ledo_blog_ta.authentication.services.UserService;
import com.amjadcode.ledo_blog_ta.commons.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/blog/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public HttpEntity<?> getUsers() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", userService.getAllUsers()), HttpStatus.OK);
    }
}
