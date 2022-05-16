package com.amjadcode.ledo_blog_ta.comments.services;

import com.amjadcode.ledo_blog_ta.authentication.repositories.UserRepository;
import com.amjadcode.ledo_blog_ta.comments.models.Comment;
import com.amjadcode.ledo_blog_ta.comments.repositories.CommentRepo;
import com.amjadcode.ledo_blog_ta.commons.CommonMethodService;
import com.amjadcode.ledo_blog_ta.posts.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepository userRepository;

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    public List<Comment> insertRandomComments() {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i<5; i++){
            comments.add(new Comment(0L, CommonMethodService.generateUsername(1),CommonMethodService.generateUsername(1)+"@gmail.com", CommonMethodService.generateUsername(10), LocalDateTime.now(), postRepo.getRandomPost()));
        }
        return commentRepo.saveAll(comments);
    }


    public List<Comment> getCommentByEmail(String email) {
        return commentRepo.findAllByEmail(email);
    }
}
