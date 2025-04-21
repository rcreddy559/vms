package com.vms.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vms.model.Event;
import com.vms.repository.EventRepository;
import com.vms.service.EventService;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("events")
    public List<Event> getAll() {
        return repository.findAll();
    }

    @Override
    public Event getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Event create(Event event) {
        return repository.save(event);
    }

    @Override
    public Event update(Long id, Event updated) {
        Event event = getById(id);
        event.setName(updated.getName());
        event.setLocation(updated.getLocation());
        event.setDate(updated.getDate());
        event.setOrganizer(updated.getOrganizer());
        return repository.save(event);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
