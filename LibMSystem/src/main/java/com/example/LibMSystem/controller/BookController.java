package com.example.LibMSystem.controller;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid BookRequest bookRequest)
    {
        Book book=bookService.addBook(bookRequest);
        return book;
    }
}
