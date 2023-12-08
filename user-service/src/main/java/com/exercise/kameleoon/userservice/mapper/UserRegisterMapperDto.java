package com.exercise.kameleoon.userservice.mapper;

import com.exercise.kameleoon.userservice.dto.UserRegisterDto;
import com.exercise.kameleoon.userservice.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class UserRegisterMapperDto implements Function<UserRegisterDto,User> {

    @Override
    public User apply(UserRegisterDto userRegisterDto) {
        return User.builder()
                .email(userRegisterDto.email())
                .username(userRegisterDto.username())
                .password(userRegisterDto.password())
                .dateCreate(LocalDate.now()).build();
    }
}
