package com.shazzar.evote.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "eventId")
    private Event event;

    private String title;

//    for each position, the final winner should be assigned to this field.
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_holder_id", referencedColumnName = "userId")
    private User Holder;

    public Position(String title, Event event) {
        this.title = title;
        this.event = event;
    }
}
