package com.exercise.kameleoon.userservice.mapper;

import com.exercise.kameleoon.userservice.dto.UserDto;
import com.exercise.kameleoon.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapperDto implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getUsername());
    }
}
