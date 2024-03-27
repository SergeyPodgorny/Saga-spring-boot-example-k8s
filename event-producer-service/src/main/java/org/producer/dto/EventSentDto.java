package org.producer.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventSentDto {

    private String variousPayload;
    private Boolean isTransactionalFailing;
    private String timeOfAttempt;
    private String timeOfReceivingMessage;
    private String timeOfSendingMessage;
    //TODO replace string with enum
    private String status;

}
