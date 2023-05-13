package com.user.user.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.user.dao.UserDAO;
import com.user.user.model.Response;
import com.user.user.model.User;

@Service
public class Userservice {

    @Autowired
    private UserDAO userDAO;

    public ResponseEntity<?> createUser(User user){
        if(user.getName()==null || user.getBirth()==null){
            Response response=new Response("Fields are missing");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        if(user.getName().isEmpty() || user.getBirth().isEmpty()  ){
            Response response=new Response("Fields are empty");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        user.setDate(LocalDate.now());
        user.setName(user.getName());
        user.setBirth(user.getBirth());
        User saved=userDAO.save(user);
        return ResponseEntity.ok(saved);
    }
    
    public ResponseEntity<?> getUserById(Long id) throws NameNotFoundException{
        Optional<User> optionalUser=userDAO.findById(id);
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            return ResponseEntity.ok(user);
        }else{
            Response response=new Response("User not found");
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        
    }

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    public ResponseEntity<?> deleteUser(Long id) throws NameNotFoundException{
        if(userDAO.existsById(id)){
            userDAO.deleteById(id);
            return ResponseEntity.ok("User Deleted");
        }else{
            Response response=new Response("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    public ResponseEntity<?> updateUser(Long id,User updatedUser) throws NameNotFoundException{
        if(updatedUser.getName()==null || updatedUser.getBirth()==null){
            Response response=new Response("Fields are missing");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        if(updatedUser.getName().isEmpty() || updatedUser.getBirth().isEmpty()  ){
            Response response=new Response("Fields are empty");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        Optional<User> optionalUser= userDAO.findById(id);
        if(optionalUser.isPresent()){
            User user=optionalUser.get();            
            user.setName(updatedUser.getName());
            user.setBirth(updatedUser.getBirth());
            User userSaved=userDAO.save(user);
            return ResponseEntity.ok(userSaved);
        }else{
            Response response=new Response("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            
        }
    }

    

}
