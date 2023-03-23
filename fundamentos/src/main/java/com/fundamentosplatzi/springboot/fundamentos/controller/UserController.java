package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.model.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(userService.getByName(name),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return new ResponseEntity<User>(userService.createUser(newUser),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Optional<User>> updateUser(@RequestBody User newUser, @PathVariable long id) {
        return new ResponseEntity<>(userService.updateUser(newUser, id),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable long id) {
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
