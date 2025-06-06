package com.example.PostCommentsApplication.services;

import com.example.PostCommentsApplication.entities.Comment;
import com.example.PostCommentsApplication.entities.Post;
import com.example.PostCommentsApplication.exceptions.ResourceNotFoundException;
import com.example.PostCommentsApplication.repositories.CommentRepository;
import com.example.PostCommentsApplication.repositories.PostRepository;
import com.example.PostCommentsApplication.requests.CommentCreate;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(Long postId, CommentCreate commentCreate) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));

        Comment comment = new Comment();
        comment.setText(commentCreate.getText());
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}