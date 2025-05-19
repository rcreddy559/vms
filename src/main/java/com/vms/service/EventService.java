package com.vms.service;

import java.util.List;

import com.vms.dto.EventDto;

public interface EventService {
    List<EventDto> getAll();

    EventDto getById(Long id);

    EventDto create(EventDto event);

    EventDto update(Long id, EventDto event);

    void delete(Long id);

}
