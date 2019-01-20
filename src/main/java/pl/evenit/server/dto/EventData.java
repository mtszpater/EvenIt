package pl.evenit.server.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class EventData {
    private Long id;

    private String name;

    private Date time;

    private String venueName;

    private BigDecimal lat;

    private BigDecimal lon;

    private String address;

    private String city;

    private String ownerName;

    private String link;

    private String description;

    private String photo;

    private String visibility;
}
