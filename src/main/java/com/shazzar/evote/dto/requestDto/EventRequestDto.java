package com.shazzar.evote.dto.requestDto;

import com.shazzar.evote.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDto {

    private String organisationName;
    private User creator;

}
