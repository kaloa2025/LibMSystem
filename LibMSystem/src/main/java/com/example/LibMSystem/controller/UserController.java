package com.example.LibMSystem.controller;

import com.example.LibMSystem.dto.UserRequest;
import com.example.LibMSystem.model.User;
import com.example.LibMSystem.repository.UserRepo;
import com.example.LibMSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Value("${student.authority}")
    private String studentAuthority;
    @Value("${admin.authority}")
    private String adminAuthority;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/addStudent")
    public User addStudent(@RequestBody UserRequest userRequest)
    {
        User user=userRequest.toUser();
        user.setAuthorities(studentAuthority);
        user.setPassword(encoder.encode(userRequest.getPassword()));
        return userRepo.save(user);
    }

    @GetMapping("/getStudent")
    public User getStudent(@RequestBody UserRequest userRequest)
    {
        return null;
    }

    @PostMapping("/addAdmin")
    public User addAdmin(@RequestBody @Valid UserRequest userRequest ){
        User user=userRequest.toUser();
        user.setAuthorities(adminAuthority);
        user.setPassword(encoder.encode(userRequest.getPassword()));
        return userRepo.save(user);
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
