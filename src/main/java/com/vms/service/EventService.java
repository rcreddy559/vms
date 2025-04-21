package com.vms.service;

import java.util.List;

import com.vms.model.Event;

public interface EventService {
    List<Event> getAll();

    Event getById(Long id);

    Event create(Event event);

    Event update(Long id, Event event);

    void delete(Long id);
}
