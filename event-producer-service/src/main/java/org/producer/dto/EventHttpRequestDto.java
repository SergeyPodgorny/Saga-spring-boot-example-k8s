package org.producer.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventHttpRequestDto {
    private String variousPayload;
    private Boolean isTransactionalFailing;
}
