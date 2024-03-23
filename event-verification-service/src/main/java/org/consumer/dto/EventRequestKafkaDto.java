package org.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestKafkaDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
    private ZonedDateTime timeOfAttempt;

}
