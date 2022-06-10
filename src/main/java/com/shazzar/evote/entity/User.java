package com.shazzar.evote.entity;

import com.shazzar.evote.entity.enums.Role;
import com.shazzar.evote.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull //uncompleted validation
    private String firstName;
    private String lastName;

//    Validate from here down
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

//    This exists for only user with role = Role.CANDIDATE
//    Candidate should pick position they're running for while signing up.
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

//    This exists for only user with role = Role.ADMIN
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Event> events;

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}


