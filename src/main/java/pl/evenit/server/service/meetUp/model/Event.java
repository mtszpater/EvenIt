package pl.evenit.server.service.meetUp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Event {
    private String id;

    private String name;

    private Date time;

    @JsonProperty("waitlist_count")
    private int waitListCount;

    @JsonProperty("yes_rsvp_count")
    private int yesRsvpCount;

    private Venue venue;

    private Group group;

    private String link;

    private String description;

    private String visibility;
}
