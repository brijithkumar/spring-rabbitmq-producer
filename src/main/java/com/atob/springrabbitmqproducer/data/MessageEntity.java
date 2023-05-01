package com.atob.springrabbitmqproducer.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageEntity {

    private String messageId;
    private String message;
    private LocalDateTime dateTime;
}
