package pl.evenit.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.evenit.server.entity.Event;
import pl.evenit.server.service.meetUp.MeetUpClient;

import java.util.List;

@RestController
public class TestController {

    private final MeetUpClient meetUpClient;

    @Autowired
    public TestController(MeetUpClient meetUpClient) {
        this.meetUpClient = meetUpClient;
    }

    @GetMapping("/test")
    public List<Event> method() {
        try {
            return this.meetUpClient.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
