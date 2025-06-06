package com.example.PostCommentsApplication.repositories;

import com.example.PostCommentsApplication.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}