package com.shazzar.evote.dto;

import com.shazzar.evote.dto.responseDto.EventResponseDto;
import com.shazzar.evote.dto.responseDto.EventResponseDto;
import com.shazzar.evote.dto.responseDto.PositionResponseDto;
import com.shazzar.evote.dto.responseDto.UserResponseDto;
import com.shazzar.evote.entity.Event;
import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.User;
import com.shazzar.evote.entity.enums.Role;

import java.util.*;

public class Mapper {

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPosition(user.getPosition());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setStatus(user.getStatus());

        return userResponseDto;
    }

    public static Set<UserResponseDto> SetOfUserToUserResponseDto(Set<User> users) {
        Set<UserResponseDto> userResponseDtoSet = new HashSet<>();

        for (User user : users) {
            userResponseDtoSet.add(userToUserResponseDto(user));
        }
        return userResponseDtoSet;
    }

    public static PositionResponseDto positionToPositionResponseDto(Position position) {
        PositionResponseDto positionResponseDto = new PositionResponseDto();

        positionResponseDto.setPositionId(position.getPositionId());
        positionResponseDto.setOrganiserName(position.getEvent().getOrganisationName());
        positionResponseDto.setTitle(position.getTitle());

        Optional<User> holder = Optional.ofNullable(position.getHolder());

        if (holder.isEmpty()) {
            positionResponseDto.setHolder("Non yet");
        } else {
            positionResponseDto.setHolder(holder.get().getFirstName() + " " + holder.get().getLastName());
        }

        return positionResponseDto;
    }

    public static List<PositionResponseDto> ListOfPositionToPositionResponseDto(List<Position> positions) {
        List<PositionResponseDto> positionResponseDtoList = new ArrayList<>();

        for (Position position : positions) {
            positionResponseDtoList.add(positionToPositionResponseDto(position));
        }

        return positionResponseDtoList;
    }

    public static EventResponseDto eventToEventResponseDto(Event event) {
        EventResponseDto eventResponseDto = new EventResponseDto();

        eventResponseDto.setEventId(event.getEventId());
        eventResponseDto.setOrganisationName(event.getOrganisationName());
        eventResponseDto.setDateCreated(event.getDateCreated());
        eventResponseDto.setCommenceDate(event.getCommenceDate());
        eventResponseDto.setEndDate(event.getEndDate());
        eventResponseDto.setCreatorName(event.getCreator().getFirstName() + " " +
                event.getCreator().getLastName());

        return eventResponseDto;
    }

    public static List<EventResponseDto> ListOfEventToEventResponseDto(List<Event> events) {
        List<EventResponseDto> eventResponseDtos = new ArrayList<>();

        for (Event event : events) {
            eventResponseDtos.add(eventToEventResponseDto(event));
        }

        return eventResponseDtos;
    }
}
