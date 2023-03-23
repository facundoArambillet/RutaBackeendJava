package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.model.Post;
import com.fundamentosplatzi.springboot.fundamentos.model.User;
import com.fundamentosplatzi.springboot.fundamentos.service.PostService;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getById(@PathVariable("id") long id) {
        return  new ResponseEntity<>(postService.getById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody Post newPost) {
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Optional<Post>> updatePost(@RequestBody Post newPost, @PathVariable long id) {
        return new ResponseEntity<>(postService.updatePost(newPost, id),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Optional<Post>> deletePost(@PathVariable long id) {
        return new ResponseEntity<>(postService.deletePost(id),HttpStatus.OK);
    }

}
