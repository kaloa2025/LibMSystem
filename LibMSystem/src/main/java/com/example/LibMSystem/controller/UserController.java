package com.example.LibMSystem.controller;

import com.example.LibMSystem.dto.UserRequest;
import com.example.LibMSystem.model.User;
import com.example.LibMSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addAdmin")
    public User addAdmin(@RequestBody @Valid UserRequest userRequest ){
        return userService.addAdmin(userRequest);
    }

    @PostMapping("/addTeacher")
    public User addTeacher(@RequestBody @Valid UserRequest userRequest ){
        return userService.addTeacher(userRequest);
    }

    @GetMapping("/filter")
    public List<User> filter(@RequestParam("filterBy") String filterBy,
                             @RequestParam("operator") String operator,
                             @RequestParam("values") String values)
    {
        return userService.filter(filterBy,operator,values);
    }

}
