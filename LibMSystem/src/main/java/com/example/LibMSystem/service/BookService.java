package com.example.LibMSystem.service;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.model.Author;
import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.repository.AuthorRepo;
import com.example.LibMSystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
