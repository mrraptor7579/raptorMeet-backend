package com.project.raptorMeet.repository;

import com.project.raptorMeet.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
   @Query("SELECT u FROM User u where u.email=:email")
    User findByEmail(String email);
}
