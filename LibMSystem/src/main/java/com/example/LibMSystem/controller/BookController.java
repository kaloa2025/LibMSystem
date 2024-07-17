package com.example.LibMSystem.controller;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.model.BookFilterType;
import com.example.LibMSystem.model.Operator;
import com.example.LibMSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/filter")
    public List<Book> filter(@RequestParam("filterBy")BookFilterType bookFilterType,
                             @RequestParam("operator")Operator operator,
                             @RequestParam("value")String value)
    {
        return bookService.filter(bookFilterType,operator,value);
    }
}
