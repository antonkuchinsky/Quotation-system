package com.exercise.kameleoon.quoteservice.client;

import com.exercise.kameleoon.quoteservice.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/v1/users/{username}")
    Optional<UserDto> getUserByUsername(@PathVariable("username") String username);
}
