package pl.evenit.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.evenit.server.dto.EventData;
import pl.evenit.server.service.EventService;

import java.util.List;

@RestController("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventData> getEvents(){
        return eventService.findAll();
    }
}
