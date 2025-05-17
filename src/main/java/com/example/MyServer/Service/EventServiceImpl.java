package com.example.MyServer.Service;

import com.example.MyServer.domain.Event;
import com.example.MyServer.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    @Override
    public Event getById(long id) {
        if(id > 0){
            return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("События нет"));
        }
        throw new RuntimeException("Id не подходит");
    }

    @Override
    public ArrayList<Event> getAllEvents() {
        return (ArrayList<Event>) eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Event event) {
        if(eventRepository.existsById(event.getId()))return eventRepository.save(event);
        throw new RuntimeException("Событие не найдено");
    }

    @Override
    public Event addEvent(Event event) {
        if(eventRepository.existsById(event.getId()))throw new RuntimeException("Событие уже существует");
        return eventRepository.save(event);

    }

    @Override
    public void deleteEventById(long id) {
        if (eventRepository.existsById(id)){
            eventRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Событие не найдена");
        }

    }

    @Override
    public ArrayList<Event> getEventsByCategory(String category) {
        return eventRepository.getEventsByCategory(category);
    }
}
