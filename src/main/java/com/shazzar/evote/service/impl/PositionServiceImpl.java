package com.shazzar.evote.service.impl;

import com.shazzar.evote.dto.Mapper;
import com.shazzar.evote.dto.requestDto.PositionRequestDto;
import com.shazzar.evote.dto.responseDto.PositionResponseDto;
import com.shazzar.evote.entity.Position;
import com.shazzar.evote.exception.AlreadyExistException;
import com.shazzar.evote.repository.PositionRepo;
import com.shazzar.evote.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionRepo positionRepo;

    public PositionServiceImpl(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    @Override
    public PositionResponseDto createPosition(PositionRequestDto positionRequestDto) {
        Position position = new Position();
        position.setTitle(positionRequestDto.getTitle());
        position.setEvent(positionRequestDto.getEvent());

//        Ensure there are not more than one position with one name under the same event
        Optional<Position> checkPosition = Optional.ofNullable(positionRepo.findByPositionTitle(positionRequestDto.getTitle()));

        if (checkPosition.isPresent()) {
            String checkOrganiser = checkPosition.get().getEvent().getOrganisationName();
            if (checkOrganiser.equals(positionRequestDto.getEvent().getOrganisationName())) {
//                Actually not done here yet
                new IllegalArgumentException("Position with the name ... exist with the organisation ...");
            }
        } else {
            positionRepo.save(position);
        }

        return Mapper.positionToPositionResponseDto(position);
    }
}
