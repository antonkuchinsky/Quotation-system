package com.exercise.kameleoon.userservice.service.impl;

import com.exercise.kameleoon.userservice.dto.UserDto;
import com.exercise.kameleoon.userservice.dto.UserRegisterDto;
import com.exercise.kameleoon.userservice.exception.InvalidDataException;
import com.exercise.kameleoon.userservice.mapper.UserMapperDto;
import com.exercise.kameleoon.userservice.mapper.UserRegisterMapperDto;
import com.exercise.kameleoon.userservice.model.User;
import com.exercise.kameleoon.userservice.repository.UserRepository;
import com.exercise.kameleoon.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapperDto userMapperDto;
    private final UserRegisterMapperDto userRegisterMapperDto;

    @Override
    @Transactional
    public User createUser(UserRegisterDto user) {
        if(!userRepository.existsByUsername(user.username())){
            return userRepository.save(userRegisterMapperDto.apply(user));
        }
        else{
            throw new InvalidDataException("The name " + user.username() + " is already busy, try another one",
                    "A user with this name was found");
        }

    }

    @Override
    public UserDto getUserByUsername(String username) {
       return userMapperDto.apply(userRepository.findByUsername(username)
               .orElseThrow(()-> new InvalidDataException("User with this name not found",
               "A user with this name wasn't found")));
    }

}
