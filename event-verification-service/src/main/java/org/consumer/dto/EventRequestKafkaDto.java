package org.consumer.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventRequestKafkaDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
    private String timeOfAttempt;

}
