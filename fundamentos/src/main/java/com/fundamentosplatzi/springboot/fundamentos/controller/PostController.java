package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.model.Post;
import com.fundamentosplatzi.springboot.fundamentos.model.User;
import com.fundamentosplatzi.springboot.fundamentos.service.PostService;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable("id") long id) {
        return  postService.getById(id);
    }

    @PostMapping()
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }

    @PutMapping("update/{id}")
    public Optional<Post> updatePost(@RequestBody Post newPost, @PathVariable long id) {
        return postService.updatePost(newPost, id);
    }

    @DeleteMapping("delete/{id}")
    public Optional<Post> deletePost(@PathVariable long id) {
        return postService.deletePost(id);
    }

}
