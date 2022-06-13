package com.shazzar.evote.dto.requestDto;

import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Long positionId;
}
