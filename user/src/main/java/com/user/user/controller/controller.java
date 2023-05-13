package com.user.user.controller;

import java.util.List;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.user.user.model.User;
import com.user.user.service.Userservice;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/users")
public class controller {

    @Autowired
    private Userservice userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        ResponseEntity<?> newUser=userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) throws NameNotFoundException{
        ResponseEntity<?> responseEntity=userService.getUserById(id);
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) throws NameNotFoundException{
        ResponseEntity<?> user=userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) throws NameNotFoundException{
        ResponseEntity<?> response=userService.deleteUser(id);
        return ResponseEntity.ok(response);
    } 
}
