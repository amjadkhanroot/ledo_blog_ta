package com.amjadcode.ledo_blog_ta.posts.controllers;

import com.amjadcode.ledo_blog_ta.authentication.models.User;
import com.amjadcode.ledo_blog_ta.authentication.services.AuthService;
import com.amjadcode.ledo_blog_ta.commons.ApiResponse;
import com.amjadcode.ledo_blog_ta.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/blog/posts")
public class PostController {

    @Autowired
    AuthService authService;
    @Autowired
    PostService postService;

    @GetMapping("/")
    public HttpEntity<?> postList() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", postService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/my-posts")
    public HttpEntity<?> commentList() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", user.getPosts()), HttpStatus.OK);
    }

    @GetMapping("/insert-random-post")
    public HttpEntity<?> insertPosts() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "",postService.insertRandomPost()), HttpStatus.OK);
    }
}
