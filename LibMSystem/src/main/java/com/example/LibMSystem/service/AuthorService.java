package com.example.LibMSystem.service;

import com.example.LibMSystem.model.Author;
import com.example.LibMSystem.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    public Author getAuthorData(String email)
    {
        return authorRepo.getAuthorByEmail(email);
    }
}
