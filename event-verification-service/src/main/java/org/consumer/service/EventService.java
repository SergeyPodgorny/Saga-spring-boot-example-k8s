package org.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.consumer.dto.EventRequestKafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventService {

    private final ObjectMapper objectMapper;

    @Autowired
    public EventService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "event-stream", groupId = "events")
    public void eventMessageListener(String event)  {

        EventRequestKafkaDto restoredObject;

        try{
            restoredObject = objectMapper.readValue(event, EventRequestKafkaDto.class);
            log.info(restoredObject.toString());
        } catch( JsonProcessingException e){
            e.printStackTrace();
        }

    }


}
