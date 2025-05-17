package com.example.MyServer.rest.controller;

import com.example.MyServer.Service.EventService;
import com.example.MyServer.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
public class EventControllerImpl implements EventController{
    private final EventService eventService;



    @GetMapping(path = "/event/{id}")
    @Override
    public Event getById(@PathVariable(name = "id") long id) {
        return eventService.getById(id);
    }
    @GetMapping(path = "/event")
    @Override
    public ArrayList<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
    @GetMapping(path = "/event/{category}")
    public ArrayList<Event> getEventsByCategory(@PathVariable(name = "category") String category){
        return eventService.getEventsByCategory(category);

    }
    @Override
    @PutMapping(path = "/event")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    @PostMapping(path = "/event")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @Override
    @DeleteMapping(path = "/event/{id}")
    public void deleteEventById(@PathVariable(name = "id") long id) {
        eventService.deleteEventById(id);

    }
}
