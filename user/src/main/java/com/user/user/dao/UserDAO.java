package com.user.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.user.model.User;
@Repository
public interface UserDAO extends JpaRepository<User, Long>{
  
}
