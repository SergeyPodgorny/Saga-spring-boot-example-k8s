package org.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.producer.dto.EventHttpRequestDto;
import org.producer.dto.EventRequestKafkaDto;
import org.producer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EventService {

    private final KafkaTemplate<String, EventRequestKafkaDto> kafkaTemplate;
    private final EventRepository eventRepository;
    @Autowired
    public EventService(KafkaTemplate<String, EventRequestKafkaDto> kafkaTemplate, EventRepository eventRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventRepository = eventRepository;
    }

    public void processEvent(EventHttpRequestDto eventDto){
        var evenRequestKafkaDto = new EventRequestKafkaDto(eventDto);

        sendMessage("event-stream", evenRequestKafkaDto);

    }

    private void sendMessage(String topicName, EventHttpRequestDto eventDto) {
        kafkaTemplate.send(topicName, new EventRequestKafkaDto(eventDto));
        log.info("Message with payload: "+eventDto+" has been sent");
    }







}
