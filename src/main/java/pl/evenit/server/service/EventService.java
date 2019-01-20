package pl.evenit.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.evenit.server.dto.EventData;
import pl.evenit.server.repository.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventData> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(e -> EventData.builder().id(e.getId()).build())
                .collect(Collectors.toList());

    }
}
