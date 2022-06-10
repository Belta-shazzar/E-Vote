package com.shazzar.evote.service.impl;

import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import com.shazzar.evote.dto.Mapper;
import com.shazzar.evote.dto.requestDto.EventRequestDto;
import com.shazzar.evote.dto.responseDto.EventResponseDto;
import com.shazzar.evote.entity.Event;
//import com.shazzar.evote.exception.AlreadyExistException;
import com.shazzar.evote.exception.AlreadyExistException;
import com.shazzar.evote.repository.EventRepository;
import com.shazzar.evote.service.EventService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventResponseDto createEvent(EventRequestDto eventRequestDto) {
        Event event = new Event();
        event.setOrganisationName(eventRequestDto.getOrganisationName());
        event.setCreator(eventRequestDto.getCreator());
        event.setDateCreated(new Date());

//        To ensure that an admin does not create two events with same organisation name.
        Optional<Event> checkForEvent =
                Optional.ofNullable(eventRepository.findByOrganisationName(eventRequestDto.getOrganisationName()));

        if (checkForEvent.isPresent()) {
//            new AlreadyExistException("Admin", "Organisation", eventRequestDto.getOrganisationName());
            throw new IllegalArgumentException("An organisation with the name " + eventRequestDto.getOrganisationName() + " already exist.");
        }

        eventRepository.save(event);

        return Mapper.eventToEventResponseDto(event);
    }
}
