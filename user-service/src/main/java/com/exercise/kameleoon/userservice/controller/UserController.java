package com.exercise.kameleoon.userservice.controller;

import com.exercise.kameleoon.userservice.dto.UserDto;
import com.exercise.kameleoon.userservice.dto.UserRegisterDto;
import com.exercise.kameleoon.userservice.model.User;
import com.exercise.kameleoon.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserRegisterDto user){
        return userService.createUser(user);
    }

    @GetMapping("{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}
