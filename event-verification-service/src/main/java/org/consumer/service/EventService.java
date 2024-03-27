package org.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.consumer.exceptions.BusinessLogicException;
import org.consumer.dto.EventReceivedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventService {
    private final EventSaveService eventSaveService;
    private final ObjectMapper objectMapper;


    @Autowired
    public EventService(EventSaveService eventSaveService, ObjectMapper objectMapper) {
        this.eventSaveService = eventSaveService;
        this.objectMapper = objectMapper;
    }
    private EventReceivedDto restoredObject;
    @KafkaListener(topics = "event-stream", groupId = "events")
    public void eventMessageListener(String event)  {

        try {
            restoredObject = objectMapper.readValue(event, EventReceivedDto.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize event: "+ event);
        }

        try {
            eventSaveService.saveEvent(restoredObject);
        } catch (BusinessLogicException e) {
            log.error("A business exception has been occurred");
        }

    }
}
