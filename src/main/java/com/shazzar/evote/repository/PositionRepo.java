package com.shazzar.evote.repository;

import com.shazzar.evote.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //Not necessary tho.
public interface PositionRepo extends JpaRepository<Position, Long> {
    @Query("select e from Position e where e.title = ?1")
    Position findByPositionTitle(String positionTitle);
}
