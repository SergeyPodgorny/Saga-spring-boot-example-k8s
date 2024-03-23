package org.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestKafkaDto extends EventHttpRequestDto {
    private ZonedDateTime timeOfAttempt;

}
