package pl.evenit.server.service.meetUp.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Venue {
    private Long id;

    private String name;

    private BigDecimal lat;

    private BigDecimal lon;

    private String address;

    private String city;
}
