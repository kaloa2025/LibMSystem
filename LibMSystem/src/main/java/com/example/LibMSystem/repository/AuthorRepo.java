package com.example.LibMSystem.repository;

import com.example.LibMSystem.model.Author;
import com.example.LibMSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
    @Query(value = "select * from author where email=:email", nativeQuery = true)
    Author getAuthorByEmail(String email);
}
