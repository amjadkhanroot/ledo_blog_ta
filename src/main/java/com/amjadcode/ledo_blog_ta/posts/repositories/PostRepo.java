package com.amjadcode.ledo_blog_ta.posts.repositories;

import com.amjadcode.ledo_blog_ta.posts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true, value = "select * from lendo_blog_posts u order by rand() limit 1")
    Post getRandomPost();

    List<Post> findAllByUser_Id(Long id);
}

