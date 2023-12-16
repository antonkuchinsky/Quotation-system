package com.exercise.kameleoon.userservice.mapper;

import com.exercise.kameleoon.userservice.dto.UserRegisterDto;
import com.exercise.kameleoon.userservice.model.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
public class UserRegisterMapperDto implements Function<UserRegisterDto,User> {

    @Override
    public User apply(UserRegisterDto userRegisterDto) {
        String hashedPassword = BCrypt.hashpw(userRegisterDto.password(), BCrypt.gensalt());
        return User.builder()
                .email(userRegisterDto.email())
                .username(userRegisterDto.username())
                .password(hashedPassword)
                .dateCreate(LocalDate.now()).build();
    }
}
