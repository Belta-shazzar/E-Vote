package com.shazzar.evote.dto.responseDto;

import com.shazzar.evote.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class EventResponseDto {
    private Long eventId;
    private String organisationName;
    private Date dateCreated;
    private Date commenceDate;
    private Date endDate;
    private String creatorName;
}
