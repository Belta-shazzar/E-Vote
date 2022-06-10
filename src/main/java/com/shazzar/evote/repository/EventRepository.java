package com.shazzar.evote.repository;

import com.shazzar.evote.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.organisationName = ?1")
    Event findByOrganisationName(String organisationName);
}
