package org.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.producer.dto.EventSentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventProcessingListenerService {

    private final ObjectMapper objectMapper;

    private EventSentDto restoredObject;

    @Autowired
    public EventProcessingListenerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "event-stream", groupId = "events")
    public void listen(String event){
        try {
            restoredObject = objectMapper.readValue(event, EventSentDto.class);
            log.error("Received object "+ restoredObject);
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize event: "+ event);
        }
    }

}
