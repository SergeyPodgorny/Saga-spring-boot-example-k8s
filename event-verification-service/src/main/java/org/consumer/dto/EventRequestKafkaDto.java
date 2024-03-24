package org.consumer.dto;

import lombok.*;
import org.consumer.entity.Event;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRequestKafkaDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
    private String timeOfAttempt;


    public EventRequestKafkaDto(Event event) {
        variousPayload= event.getVariousPayload();
        isTransactionalFailing = event.getIsTransactionalFailing();
        timeOfAttempt = event.getTimeOfAttempt();
    }
}
