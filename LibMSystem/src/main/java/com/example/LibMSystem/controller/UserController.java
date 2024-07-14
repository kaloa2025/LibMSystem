package com.example.LibMSystem.controller;

import com.example.LibMSystem.dto.UserRequest;
import com.example.LibMSystem.model.User;
import com.example.LibMSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    public User addStudent(@RequestBody UserRequest userRequest)
    {
        return userService.addStudent(userRequest);
    }

//    @PostMapping("/addAdmin")
//    public User addAdmin(@RequestBody UserRequest userRequest)
//    {
//        return null;
//    }

}
