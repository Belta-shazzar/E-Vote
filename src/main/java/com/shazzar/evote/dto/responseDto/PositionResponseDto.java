package com.shazzar.evote.dto.responseDto;

import com.shazzar.evote.entity.Position;
import com.shazzar.evote.entity.User;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
public class PositionResponseDto {
    private Long positionId;
    private String organiserName;
    private String title;
    private String Holder;

}
