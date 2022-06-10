package com.shazzar.evote.service;

import com.shazzar.evote.dto.requestDto.UserRequestDto;
import com.shazzar.evote.dto.responseDto.UserResponseDto;
import com.shazzar.evote.exception.ResourceNotFoundException;

public interface UserService {
    UserResponseDto addUser(UserRequestDto userRequestDto);
    UserResponseDto getById(Long id) throws ResourceNotFoundException;
}
