package org.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
public class EventRequestKafkaDto extends EventHttpRequestDto{

    private ZonedDateTime timeOfAttempt;
    public EventRequestKafkaDto(EventHttpRequestDto eventHttpRequestDto) {
        super.setVariousPayload(eventHttpRequestDto.getVariousPayload());
        super.setIsTransactionalFailing(eventHttpRequestDto.getIsTransactionalFailing());

        LocalDateTime localDateTime = LocalDateTime.now();
        this.timeOfAttempt = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
    }

}
