package org.consumer.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.consumer.dto.EventReceivedDto;
import org.hibernate.annotations.GenericGenerator;

import java.time.ZonedDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Event {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    private String id;
    private String variousPayload;
    private String timeOfAttempt;
    private String timeOfReceivingMessage;

    public Event(EventReceivedDto dto) {
        variousPayload = dto.getVariousPayload();
        timeOfAttempt = dto.getTimeOfAttempt();
        timeOfReceivingMessage = dto.getTimeOfReceivingMessage();
    }
}
