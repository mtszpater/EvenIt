package pl.evenit.server.service.meetUp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GroupPhoto {
    @JsonProperty("photo_link")
    private String photoLink;
}
