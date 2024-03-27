package org.consumer.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventSentDto extends EventReceivedDto {

    private String timeOfSendingMessage = setCurrentTime();
    //TODO replace string with enum
    private String status;

    public EventSentDto(EventReceivedDto dto, String status) {
        super.setVariousPayload(dto.getVariousPayload());
        super.setIsTransactionalFailing(dto.getIsTransactionalFailing());
        super.setTimeOfAttempt(dto.getTimeOfAttempt());
        super.setTimeOfReceivingMessage(dto.getTimeOfReceivingMessage());
        timeOfSendingMessage = setCurrentTime();
        this.status = status;
    }

}
