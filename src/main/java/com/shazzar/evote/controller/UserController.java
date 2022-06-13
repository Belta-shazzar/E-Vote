package com.shazzar.evote.controller;

import com.shazzar.evote.dto.requestDto.UserRequestDto;
import com.shazzar.evote.dto.responseDto.UserResponseDto;
import com.shazzar.evote.service.UserService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    http://localhost:8082/user/add-user
    @PostMapping("/add-user")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody @Validated UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

//    http://localhost:8082/user/get-user/{id}
    @SneakyThrows
    @GetMapping("get-user/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") long id) {
        UserResponseDto userResponseDto = userService.getById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
