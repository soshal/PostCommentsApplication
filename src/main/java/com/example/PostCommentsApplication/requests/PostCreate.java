package com.example.PostCommentsApplication.requests;

public class PostCreate {
    @NotBlank
    @Size(max = 200)
    private String title;

    @NotBlank
    private String content;

    // Getters and setters
}