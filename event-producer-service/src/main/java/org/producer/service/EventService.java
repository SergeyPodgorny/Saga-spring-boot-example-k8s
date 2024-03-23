package org.producer.service;

import org.producer.dto.EventDto;
import org.producer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EventRepository eventRepository;

    @Autowired
    public EventService(KafkaTemplate<String, String> kafkaTemplate, EventRepository eventRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventRepository = eventRepository;
    }


    public void processEvent(EventDto eventDto){

    }






}
