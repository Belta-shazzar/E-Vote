package com.shazzar.evote.dto.requestDto;

import com.shazzar.evote.entity.Event;
import com.shazzar.evote.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionRequestDto {
 private String title;
 private Event event;
}
