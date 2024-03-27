package org.consumer.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventReceivedDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
    private String timeOfAttempt;
    private String timeOfReceivingMessage = setCurrentTime();

    protected String setCurrentTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        return zonedDateTime.format(formatter);
    }
}
