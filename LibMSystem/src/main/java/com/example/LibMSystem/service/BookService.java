package com.example.LibMSystem.service;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.model.*;
import com.example.LibMSystem.repository.AuthorRepo;
import com.example.LibMSystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;

    public Book addBook(BookRequest bookRequest)
    {
        Author authorFromDB=authorRepo.getAuthorByEmail(bookRequest.getAuthorEmail());
        if(authorFromDB==null)
        {
            authorFromDB=authorRepo.save(bookRequest.toAuthor());
        }
        Book book=bookRequest.toBook();
        book.setAuthor(authorFromDB);
        return bookRepo.save(book);
    }

    public List<Book> filter(BookFilterType bookFilterType, Operator operator, String value) {
        switch(bookFilterType)
        {
            case BOOK_TITLE :
                switch (operator)
                {
                    case EQUALS : return bookRepo.findByTitle(value);
                    case LIKE: return bookRepo.findByTitleContaining(value);
                    default: return new ArrayList<>();
                }
            case BOOK_TYPE:
                switch (operator)
                {
                    case EQUALS : return bookRepo.findByBookType(BookType.valueOf(value));
                    default: return new ArrayList<>();
                }
            case SECURITY_AMOUNT:
                switch (operator)
                {
                    case EQUALS : return bookRepo.findBySecurityAmount(Integer.valueOf(value));
                }
            case BOOK_NO:
                switch(operator)
                {
                    case EQUALS : return bookRepo.findByBookNo(value);
                    default:return new ArrayList<>();
                }
        }
        return new ArrayList<>();
    }
    public void updateBookData(Book bookFromDb)
    {
        bookRepo.save(bookFromDb);
    }
}
