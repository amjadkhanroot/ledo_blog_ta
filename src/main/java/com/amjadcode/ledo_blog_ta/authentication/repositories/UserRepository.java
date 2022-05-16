package com.amjadcode.ledo_blog_ta.authentication.repositories;

import com.amjadcode.ledo_blog_ta.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsAllByEmailOrUsername(String email, String username);

    List<User> findAllByActiveTrue();


    @Query(nativeQuery = true, value = "select * from lendo_blog_users u order by rand() limit 1")
    User getRandomUser();

}