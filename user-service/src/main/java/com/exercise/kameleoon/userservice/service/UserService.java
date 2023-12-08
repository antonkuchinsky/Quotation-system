package com.exercise.kameleoon.userservice.service;

import com.exercise.kameleoon.userservice.dto.UserDto;
import com.exercise.kameleoon.userservice.dto.UserRegisterDto;
import com.exercise.kameleoon.userservice.model.User;

public interface UserService {
    User createUser(UserRegisterDto user);
    UserDto getUserByUsername(String username);
}
