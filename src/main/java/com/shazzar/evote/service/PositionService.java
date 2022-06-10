package com.shazzar.evote.service;

import com.shazzar.evote.dto.requestDto.PositionRequestDto;
import com.shazzar.evote.dto.responseDto.PositionResponseDto;

public interface PositionService {
    PositionResponseDto createPosition(PositionRequestDto positionRequestDto);
}
