package pl.evenit.server.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "EVENT")
@Data
@Builder
public class Event {
    @GeneratedValue
    @Id
    private Long id;

    private String foreignId;

    private String name;

    private Date time;

    private int waitListCount;

    private int yesCount;

    private String venueName;

    private BigDecimal lat;

    private BigDecimal lon;

    private String address;

    private String city;

    private String meetupGroupId;

    private String ownerName;

    private String link;

    @Lob
    private String description;

    private String photo;

    private String visibility;

    @Tolerate
    Event() {}
}
