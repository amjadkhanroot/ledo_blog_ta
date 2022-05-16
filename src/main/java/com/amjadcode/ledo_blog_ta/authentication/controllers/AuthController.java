package com.amjadcode.ledo_blog_ta.authentication.controllers;

import com.amjadcode.ledo_blog_ta.authentication.models.User;
import com.amjadcode.ledo_blog_ta.authentication.payloads.requests.LoginRequest;
import com.amjadcode.ledo_blog_ta.authentication.services.AuthService;
import com.amjadcode.ledo_blog_ta.authentication.services.UserService;
import com.amjadcode.ledo_blog_ta.commons.ApiResponse;
import com.amjadcode.ledo_blog_ta.security.services.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encode;

    @PostMapping("/login")
    public HttpEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        //for demo only the password is fixed.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), "password"));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();

        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "Logged In!", userDetails, jwt), HttpStatus.OK);
    }

    @GetMapping("/insert-random-users")
    public HttpEntity<?> insertUsers() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", userService.insertRandomUser()), HttpStatus.OK);
    }
}
