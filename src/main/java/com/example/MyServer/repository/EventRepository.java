package com.example.MyServer.repository;

import com.example.MyServer.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    ArrayList<Event> getEventsByCategory(String category);
    Event getEventByEventLocation(String eventLocation);

}
