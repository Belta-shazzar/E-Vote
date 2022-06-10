package com.shazzar.evote.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String organisationName;
    private Date dateCreated;
    private Date commenceDate;
    private Date endDate;

    @OneToMany(mappedBy = "event")
    private Set<Position> positions;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", referencedColumnName = "userId")
    private User creator;

    @Transient
    private Map<Position, Set<User>> election;


    public Event(String organisationName, User creator) {
        this.organisationName = organisationName;
        this.creator = creator;
    }
}
