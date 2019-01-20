package pl.evenit.server.service.meetUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.evenit.server.entity.MeetUpGroup;
import pl.evenit.server.repository.EventRepository;
import pl.evenit.server.repository.MeetUpGroupRepository;
import pl.evenit.server.service.meetUp.model.Event;
import pl.evenit.server.service.meetUp.model.Group;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class MeetUpClient {
    @Value("${meetup.api.key}")
    private String apiKey;

    @Value("${meetup.api.url}")
    private String apiUrl;

    private final EventRepository eventRepository;

    private final MeetUpGroupRepository meetUpGroupRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public MeetUpClient(EventRepository eventRepository, MeetUpGroupRepository meetUpGroupRepository) {
        this.eventRepository = eventRepository;
        this.meetUpGroupRepository = meetUpGroupRepository;
    }

    public List<pl.evenit.server.entity.Event> sync() throws InterruptedException {

        int count = 0;
        for (MeetUpGroup group : getAllGroups()) {
            ++count;

            Event[] temporaryEventList = restTemplate.getForObject(apiUrl + "/" + group.getUrlName() + "/events?key=" + apiKey, Event[].class);
            if (temporaryEventList != null) {
                saveOrUpdate(Arrays.asList(temporaryEventList), group.getPhoto());
            }

            if (count % 2 == 0) {
                Thread.sleep(1000);
            }
        }

        return eventRepository.findAll();
    }

    private void saveOrUpdate(List<Event> events, String photo) {
        events.stream().filter(e -> e.getVenue() != null).forEach(e -> {
            if (!eventRepository.existsByForeignId(e.getId())) {
                eventRepository.saveAndFlush(pl.evenit.server.entity.Event.builder()
                        .address(e.getVenue().getAddress())
                        .city(e.getVenue().getCity())
                        .foreignId(e.getId())
                        .name(e.getName())
                        .time(e.getTime())
                        .waitListCount(e.getWaitListCount())
                        .yesCount(e.getYesRsvpCount())
                        .venueName(e.getVenue().getName())
                        .lat(e.getVenue().getLat())
                        .lon(e.getVenue().getLon())
                        .photo(photo)
                        .meetupGroupId(e.getGroup().getId())
                        .ownerName(e.getGroup().getName())
                        .link(e.getLink())
                        .description(e.getDescription())
                        .visibility(e.getVisibility()).build());
            }
        });
    }

    private List<MeetUpGroup> getAllGroups() {
        List<Group> groups = Arrays.asList(restTemplate.getForObject(apiUrl + "/self/groups?key=" + apiKey, Group[].class));
        Predicate<Group> groupsFromPoland = g -> "PL".equals(g.getCountry());

        groups.stream().filter(groupsFromPoland).forEach(g -> {
            if (!meetUpGroupRepository.existsByForeignId(g.getId())) {
                meetUpGroupRepository.save(MeetUpGroup.builder()
                        .foreignId(g.getId())
                        .name(g.getName())
                        .urlName(g.getUrlName())
                        .photo(g.getGroupPhoto().getPhotoLink())
                        .build());
            }
        });

        return meetUpGroupRepository.findAll();
    }

}
