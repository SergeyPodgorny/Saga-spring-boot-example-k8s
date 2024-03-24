package org.producer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class EventRequestKafkaDto extends EventHttpRequestDto{

    private String timeOfAttempt;
    public EventRequestKafkaDto(EventHttpRequestDto eventHttpRequestDto) {
        super.setVariousPayload(eventHttpRequestDto.getVariousPayload());
        super.setIsTransactionalFailing(eventHttpRequestDto.getIsTransactionalFailing());
        this.timeOfAttempt = initTimeOfAttempt();
    }


    private String initTimeOfAttempt(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        return zonedDateTime.format(formatter);
    }

}
