package com.example.LibMSystem.repository;

import com.example.LibMSystem.model.User;
import com.example.LibMSystem.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where :query", nativeQuery = true)
    List<User> findUsersByNativeQuery(@Param("query") String q);
    User findByPhoneNoAndUserType(String phoneNo, UserType type);
    User findByEmail(String email);
}
