package com.shazzar.evote.controller;

import com.shazzar.evote.dto.requestDto.EventRequestDto;
import com.shazzar.evote.dto.responseDto.EventResponseDto;
import com.shazzar.evote.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create-event")
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        EventResponseDto eventResponseDto = eventService.createEvent(eventRequestDto);

        return new ResponseEntity<>(eventResponseDto, HttpStatus.CREATED);
    }
}
