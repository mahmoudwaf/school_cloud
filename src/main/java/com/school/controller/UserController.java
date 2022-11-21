package com.school.controller;

import com.school.model.User;
import com.school.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    LoginService loginService;
    @PostMapping("/addUser")
    public User signUp(@RequestBody User user){
        return loginService.saveUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return loginService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable long userId){
        loginService.deleteUser(userId);
        return true;
    }



}
