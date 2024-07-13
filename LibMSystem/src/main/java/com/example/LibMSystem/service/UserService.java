package com.example.LibMSystem.service;

import com.example.LibMSystem.dto.BookRequest;
import com.example.LibMSystem.dto.UserRequest;
import com.example.LibMSystem.model.Author;
import com.example.LibMSystem.model.Book;
import com.example.LibMSystem.model.User;
import com.example.LibMSystem.model.UserType;
import com.example.LibMSystem.repository.AuthorRepo;
import com.example.LibMSystem.repository.BookRepo;
import com.example.LibMSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo UserRepo;

    public User addStudent(UserRequest userRequest)
    {
        User user=userRequest.toUser();
        user.setUserType(UserType.STUDENT);
        return UserRepo.save(user);
    }
}
