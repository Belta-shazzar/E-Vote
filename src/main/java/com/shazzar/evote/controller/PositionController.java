package com.shazzar.evote.controller;

import com.shazzar.evote.dto.requestDto.PositionRequestDto;
import com.shazzar.evote.dto.responseDto.PositionResponseDto;
import com.shazzar.evote.service.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/add-position")
    public ResponseEntity<PositionResponseDto> createPosition(@RequestBody PositionRequestDto positionRequestDto) {
        PositionResponseDto positionResponseDto = positionService.createPosition(positionRequestDto);

        return new ResponseEntity<>(positionResponseDto, HttpStatus.CREATED);
    }
}
