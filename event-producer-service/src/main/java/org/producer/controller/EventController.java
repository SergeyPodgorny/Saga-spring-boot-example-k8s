package org.producer.controller;

import org.producer.dto.EventHttpRequestDto;
import org.producer.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {



    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/v1/process")
    public void precessEvent(@RequestBody EventHttpRequestDto eventDto){
        eventService.processEvent(eventDto);
    }


}
