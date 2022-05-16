package com.amjadcode.ledo_blog_ta.comments.repositories;

import com.amjadcode.ledo_blog_ta.comments.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long id);

    List<Comment> findAllByEmail(String email);
}

