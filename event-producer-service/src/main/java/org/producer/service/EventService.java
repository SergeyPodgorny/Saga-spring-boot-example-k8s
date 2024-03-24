package org.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.producer.dto.EventHttpRequestDto;
import org.producer.dto.EventRequestKafkaDto;
import org.producer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@Slf4j
public class EventService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public EventService(KafkaTemplate<String, String> kafkaTemplate, EventRepository eventRepository, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }

    public void processEvent(EventHttpRequestDto eventDto){

        var evenRequestKafkaDto = new EventRequestKafkaDto();
        evenRequestKafkaDto.setTimeOfAttempt(ZonedDateTime.now());

        sendMessage("event-stream", evenRequestKafkaDto);



    }

    private void sendMessage(String topicName, EventHttpRequestDto eventDto) {
        var jsonEventDto = mutateToJson(eventDto);
        kafkaTemplate.send(topicName, jsonEventDto);
        log.info(jsonEventDto + " has been sent");
    }

    private String mutateToJson(EventHttpRequestDto eventDto){
        try {
            return objectMapper.writeValueAsString(eventDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }






}
