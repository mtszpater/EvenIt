package pl.evenit.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.evenit.server.dto.EventData;
import pl.evenit.server.entity.Event;
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
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private EventData convertEntityToDTO(Event e) {
        return EventData.builder()
                .id(e.getId())
                .name(e.getName())
                .time(e.getTime())
                .venueName(e.getVenueName())
                .lat(e.getLat())
                .lon(e.getLon())
                .address(e.getAddress())
                .city(e.getCity())
                .ownerName(e.getOwnerName())
                .link(e.getLink())
                .description(e.getDescription())
                .photo(e.getPhoto())
                .visibility(e.getVisibility())
                .build();
    }
}
