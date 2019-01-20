package pl.evenit.server.service.meetUp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Group {
    private String name;

    private String country;

    private String id;

    private BigDecimal lat;

    private BigDecimal lon;

    @JsonProperty("urlname")
    private String urlName;

    private String link;

    @JsonProperty("localized_location")
    private String localizedLocation;

    @JsonProperty("group_photo")
    private GroupPhoto groupPhoto = new GroupPhoto();
}
