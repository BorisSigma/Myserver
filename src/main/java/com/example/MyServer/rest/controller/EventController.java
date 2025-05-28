package com.example.MyServer.rest.controller;

import com.example.MyServer.domain.Event;

import java.util.ArrayList;

public interface EventController {
    Event getById(long id);
    ArrayList<Event> getAllEvents();
    Event updateEvent(Event event);
    Event addEvent(Event event);
    ArrayList<Event> getEventsByCategory(String category);
    void deleteEventById(long id);
    Event getEventByLatLng(String eventLocation);
}
