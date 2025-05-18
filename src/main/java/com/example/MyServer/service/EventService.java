package com.example.MyServer.service;

import com.example.MyServer.domain.Event;

import java.util.ArrayList;

public interface EventService {
    Event getById(long id);
    ArrayList<Event> getAllEvents();
    Event updateEvent(Event event);
    Event addEvent(Event event);
    void deleteEventById(long id);
    ArrayList<Event> getEventsByCategory(String category);
}
