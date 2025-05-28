package com.example.MyServer.service;

import com.example.MyServer.domain.Event;
import com.example.MyServer.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@RequestMapping
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    @Override
    @Transactional(readOnly = true)
    public Event getById(long id) {
        if(id > 0){
            return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("События нет"));
        }
        throw new RuntimeException("Id не подходит");
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Event> getAllEvents() {
        return (ArrayList<Event>) eventRepository.findAll();
    }

    @Override
    @Transactional
    public Event updateEvent(Event event) {
        if(eventRepository.existsById(event.getId()))return eventRepository.save(event);
        throw new RuntimeException("Событие не найдено");
    }

    @Override
    @Transactional
    public Event addEvent(Event event) {
        if(eventRepository.existsById(event.getId()))throw new RuntimeException("Событие уже существует");
        return eventRepository.save(event);

    }

    @Override
    @Transactional
    public void deleteEventById(long id) {
        if (eventRepository.existsById(id)){
            eventRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Событие не найдена");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Event> getEventsByCategory(String category) {
        return eventRepository.getEventsByCategory(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Event getEventByEventLocation(String eventLocation) {
        return eventRepository.getEventByEventLocation(eventLocation);
    }


}
