package com.user.user.controller;

import java.util.List;

import javax.naming.NameNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.user.user.model.Response;
import com.user.user.model.User;
import com.user.user.service.Userservice;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/users")
public class controller {

    @Autowired
    private Userservice userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<Object> createUser(@RequestBody User user){
        Response newUser=userService.createUser(user);
        return ResponseEntity.status(newUser.getStatus()).body(newUser.getBody());
    }
    // @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // public ResponseEntity<Object> createUser(@RequestParam String name, @RequestParam String birth){
    //     User user=new User(name, birth);
    //     Response newUser=userService.createUser(user);
    //     return ResponseEntity.status(newUser.getStatus()).body(newUser.getBody());
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) throws NameNotFoundException{
        Response response=userService.getUserById(id);
        return ResponseEntity.status(response.getStatus()).body(response.getBody());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) throws NameNotFoundException{
        Response user=userService.updateUser(id, updatedUser);
        return ResponseEntity.status(user.getStatus()).body(user.getBody());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) throws NameNotFoundException{
        Response response=userService.deleteUser(id);
        return ResponseEntity.status(response.getStatus()).body(response.getBody());
    }


}
