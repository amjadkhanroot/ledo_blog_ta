package com.amjadcode.ledo_blog_ta.comments.controllers;

import com.amjadcode.ledo_blog_ta.authentication.models.User;
import com.amjadcode.ledo_blog_ta.authentication.services.AuthService;
import com.amjadcode.ledo_blog_ta.comments.services.CommentService;
import com.amjadcode.ledo_blog_ta.commons.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/blog/comments")
public class CommentController {
    @Autowired
    AuthService authService;
    @Autowired
    CommentService commentService;

    @GetMapping("/")
    public HttpEntity<?> commentList() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", commentService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/my-comments")
    public HttpEntity<?> myComment() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "", commentService.getCommentByEmail(user.getEmail())), HttpStatus.OK);
    }

    @GetMapping("/insert-random-comment")
    public HttpEntity<?> insertComments() {
        return new ResponseEntity<>(new ApiResponse(true, "200", "success", "",commentService.insertRandomComments()), HttpStatus.OK);
    }
}
