package com.shazzar.evote.dto.responseDto;

import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.enums.Role;
import com.shazzar.evote.entity.enums.Status;
import lombok.Data;

@Data
public class CandidateResponseDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private Status status;
    private Position position;
}
