package com.vms.controller;

import com.vms.dto.EventDto;
import org.springframework.web.bind.annotation.*;
import com.vms.service.EventService;
import java.util.List;

@RestController
@RequestMapping("/vms/api/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        return eventService.getById(id);
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto event) {
        return eventService.create(event);
    }

    @PutMapping("/{id}")
    public EventDto updateEvent(@PathVariable Long id, @RequestBody EventDto event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
    }
    
}
