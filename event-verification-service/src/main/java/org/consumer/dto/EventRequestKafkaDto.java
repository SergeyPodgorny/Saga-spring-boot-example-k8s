package org.consumer.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRequestKafkaDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
    private ZonedDateTime timeOfAttempt;

}
