package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.model.Post;
import com.fundamentosplatzi.springboot.fundamentos.model.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.PostRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Optional<Post> getById(long id) {
        return  postRepository.findById(id);
    }

    public Post createPost(Post newPost) {
        return postRepository.save(newPost);
    }

    public Optional<Post> updatePost(Post newPost, long id) {
        return postRepository.findById(id).map(
                post -> {
                    post.setDescription(newPost.getDescription());
                    return postRepository.save(post);
                }
        );
    }

    public Optional<Post> deletePost(long id) {
        Optional<Post> postDeleted = postRepository.findById(id);
        postRepository.deleteById(id);
        return postDeleted;
    }
}
