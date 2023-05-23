package com.user.user.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.user.dao.UserDAO;
import com.user.user.interfaces.Results;
import com.user.user.model.Error;
import com.user.user.model.Response;
import com.user.user.model.User;

@Service
public class Userservice {

    @Autowired
    private UserDAO userDAO;

    public Response createUser(User user){
        if(user.getName()==null || user.getBirth()==null){
            Results error = new Error("Fields are missing");
            return new Response(error, HttpStatus.BAD_REQUEST);
        }
        if(user.getName().isEmpty() || user.getBirth().isEmpty()  ){
            Results error = new Error("Field/s are empty");
            
            System.out.println(error);
            return new Response(error, HttpStatus.BAD_REQUEST);
        }
        user.setDate(LocalDate.now());
        Results userSaved=userDAO.save(user);
        return new Response(userSaved, HttpStatus.OK);
    }
    
    public Response getUserById(Long id) throws NameNotFoundException{
        Optional<User> optionalUser=userDAO.findById(id);
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            return new Response(user, HttpStatus.OK);
        }else{
            Error response=new Error("User not found");
           return new Response(response, HttpStatus.NOT_FOUND);
        }
        
    }

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

    public Response deleteUser(Long id) throws NameNotFoundException{
        if(userDAO.existsById(id)){
            userDAO.deleteById(id);
            return new Response(new com.user.user.model.Message("User deleted"),HttpStatus.OK);
        }else{
            Error response=new Error("User not found");
            return new Response(response, HttpStatus.NOT_FOUND);
        }
    }

    public Response updateUser(Long id,User updatedUser) throws NameNotFoundException{
        if(updatedUser.getName()==null || updatedUser.getBirth()==null){
            Error response=new Error("Fields are missing");
            return new Response(response, HttpStatus.BAD_REQUEST);
        }
        if(updatedUser.getName().isEmpty() || updatedUser.getBirth().isEmpty()  ){
            Error response=new Error("Fields are empty");
            return new Response(response, HttpStatus.valueOf(400));
        }
        Optional<User> optionalUser= userDAO.findById(id);
        if(optionalUser.isPresent()){
            User user=optionalUser.get();            
            user.setName(updatedUser.getName());
            user.setBirth(updatedUser.getBirth());
            User userSaved=userDAO.save(user);
            return new Response(userSaved, HttpStatus.OK);
        }else{
            Error response=new Error("User not found");
            return new Response(response, HttpStatus.NOT_FOUND);            
        }
    }





}
