package pl.evenit.server.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "GROUP_MEETUP")
@Data
@Builder
public class MeetUpGroup {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String foreignId;

    private String urlName;

    private String photo;

    @Tolerate
    MeetUpGroup() {
    }
}
