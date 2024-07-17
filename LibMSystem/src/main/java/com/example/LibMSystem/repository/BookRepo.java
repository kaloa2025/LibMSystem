package com.example.LibMSystem.repository;

import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.model.BookType;
import com.example.LibMSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByBookType(BookType bookType);
    List<Book> findByBookNo(String bookNo);
    List<Book> findBySecurityAmount(Integer securityAmount);
//    List<Book> findByAuthorName(String authorName);
}