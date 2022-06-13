package com.shazzar.evote.service.impl;

import com.shazzar.evote.dto.Mapper;
import com.shazzar.evote.dto.requestDto.UserRequestDto;
import com.shazzar.evote.dto.responseDto.UserResponseDto;
import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.User;
import com.shazzar.evote.entity.enums.Role;
import com.shazzar.evote.entity.enums.Status;
import com.shazzar.evote.exception.ResourceNotFoundException;
import com.shazzar.evote.repository.PositionRepo;
import com.shazzar.evote.repository.UserRepository;
import com.shazzar.evote.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PositionRepo positionRepo;

    public UserServiceImpl(UserRepository userRepository, PositionRepo positionRepo) {
        this.userRepository = userRepository;
        this.positionRepo = positionRepo;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(userRequestDto.getRole());

//        All user with Role.ADMIN should be activated by default
        if (userRequestDto.getRole() == Role.ADMIN) {
            user.setStatus(Status.ACTIVE);
        } else {
            user.setStatus(Status.DEACTIVATED);
        }

        if(userRequestDto.getRole() == Role.CANDIDATE){

            Optional<Position> position = positionRepo.findById(userRequestDto.getPositionId());

            if(position.isPresent()){
                user.setPosition(position.get());
            } else {
                new IllegalArgumentException("Position field must not be empty for candidate");
            }
        }



        userRepository.save(user);
        return Mapper.userToUserResponseDto(user);
    }

    @SneakyThrows
    @Override
    public UserResponseDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        return Mapper.userToUserResponseDto(user);
    }
}
