package com.shazzar.evote;

import com.shazzar.evote.dto.requestDto.EventRequestDto;
import com.shazzar.evote.dto.requestDto.PositionRequestDto;
import com.shazzar.evote.dto.requestDto.UserRequestDto;
import com.shazzar.evote.entity.Event;
import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.User;
import com.shazzar.evote.entity.enums.Role;
import com.shazzar.evote.repository.EventRepository;
import com.shazzar.evote.repository.UserRepository;
import com.shazzar.evote.service.EventService;
import com.shazzar.evote.service.PositionService;
import com.shazzar.evote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class EVoteApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EVoteApplication.class, args);
    }

    private UserRepository userRepository;
    private EventService eventService;
    private EventRepository eventRepository;
    private PositionService positionService;
    private UserService userService;

    public EVoteApplication(UserRepository userRepository, EventService eventService,
                            EventRepository eventRepository, PositionService positionService, UserService userService) {
        this.userRepository = userRepository;
        this.eventService = eventService;
        this.eventRepository = eventRepository;
        this.positionService = positionService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

//        UserRequestDto user = new UserRequestDto("Daniel", "Mba", "Dan@gmail.com", "secret", Role.ADMIN);
//
//        userService.addUser(user);

//        User user1 = userRepository.findById(1l).get();
//        User user2 = userRepository.findById(2l).get();
//

        Optional<Event> event1 = eventRepository.findById(1l);

        if(event1.isPresent()) {
//
            PositionRequestDto positionRequestDto1 = new PositionRequestDto("SUG President", event1.get());
            PositionRequestDto positionRequestDto2 = new PositionRequestDto("SUG Vice", event1.get());
            PositionRequestDto positionRequestDto3 = new PositionRequestDto("SUG Sec Gen", event1.get());
            PositionRequestDto positionRequestDto4 = new PositionRequestDto("D.O.S", event1.get());
            PositionRequestDto positionRequestDto5 = new PositionRequestDto("D.O.G", event1.get());
//
            positionService.createPosition(positionRequestDto1);
            positionService.createPosition(positionRequestDto2);
            positionService.createPosition(positionRequestDto3);
            positionService.createPosition(positionRequestDto4);
            positionService.createPosition(positionRequestDto5);
        }

//
//        EventRequestDto eventRequestDto1 = new EventRequestDto("UNN", user1);
//        EventRequestDto eventRequestDto2 = new EventRequestDto("UNEC", user2);
//        EventRequestDto eventRequestDto3 = new EventRequestDto("ESUT", user1);
//        EventRequestDto eventRequestDto4 = new EventRequestDto("Apple", user1);
//        EventRequestDto eventRequestDto5 = new EventRequestDto("Shoprite", user2);
//
//        eventService.createEvent(eventRequestDto1);
//        eventService.createEvent(eventRequestDto2);
//        eventService.createEvent(eventRequestDto3);
//        eventService.createEvent(eventRequestDto4);
//        eventService.createEvent(eventRequestDto5);
    }
}



