package pl.evenit.server.service.meetUp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Venue {
    private Long id;

    private String name;

    private BigDecimal lat;

    private BigDecimal lon;

    @JsonProperty("address_1")
    private String address;

    private String city;
}
