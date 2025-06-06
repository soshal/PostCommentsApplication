package com.example.PostCommentsApplication.services;

import com.example.PostCommentsApplication.entities.Post;
import com.example.PostCommentsApplication.exceptions.ResourceNotFoundException;
import com.example.PostCommentsApplication.repositories.PostRepository;
import com.example.PostCommentsApplication.requests.PostCreate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(PostCreate postCreate) {
        Post post = new Post();
        post.setTitle(postCreate.getTitle());
        post.setContent(postCreate.getContent());
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }
}