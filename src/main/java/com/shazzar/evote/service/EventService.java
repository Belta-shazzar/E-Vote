package com.shazzar.evote.service;

import com.shazzar.evote.dto.requestDto.EventRequestDto;
import com.shazzar.evote.dto.responseDto.EventResponseDto;

public interface EventService {
    EventResponseDto createEvent(EventRequestDto eventRequestDto);
}
