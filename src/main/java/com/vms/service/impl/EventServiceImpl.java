package com.vms.service.impl;

import com.vms.dto.EventDto;
import com.vms.model.Event;
import com.vms.repository.EventRepository;
import com.vms.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final ModelMapper modelMapper;

    public EventServiceImpl(EventRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Cacheable("events")
    public List<EventDto> getAll() {
        var events = repository.findAll();
        return events.stream().map(e -> modelMapper.map(e, EventDto.class)).toList();
    }

    @Override
    public EventDto getById(Long id) {
        Event event = repository.findById(id).orElseThrow();
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        Event savedEvent = repository.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    @Override
    public EventDto update(Long id, EventDto updated) {
        Event event = repository.findById(id).orElseThrow();
        event.setName(updated.getName());
        event.setLocation(updated.getLocation());
        event.setStartDate(updated.getStartDate());
        event.setEndDate(updated.getEndDate());

        Event savedEvent = repository.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
