package com.example.LibMSystem.repository;

import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
