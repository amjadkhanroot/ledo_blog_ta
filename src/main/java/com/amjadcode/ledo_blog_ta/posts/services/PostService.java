package com.amjadcode.ledo_blog_ta.posts.services;


import com.amjadcode.ledo_blog_ta.authentication.models.User;
import com.amjadcode.ledo_blog_ta.authentication.repositories.UserRepository;
import com.amjadcode.ledo_blog_ta.commons.CommonMethodService;
import com.amjadcode.ledo_blog_ta.posts.models.Post;
import com.amjadcode.ledo_blog_ta.posts.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepository userRepository;

    public List<Post> getAll() {
        return postRepo.findAll();
    }

    public List<Post> insertRandomPost() {
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i<5; i++){
            posts.add(new Post(0L, CommonMethodService.generateUsername(5),CommonMethodService.generateUsername(10), userRepository.getRandomUser(), new ArrayList<>(), LocalDateTime.now()));
        }
        return postRepo.saveAll(posts);
    }


    public List<Post> getMyPosts(Long id) {
        return postRepo.findAllByUser_Id(id);
    }
}
