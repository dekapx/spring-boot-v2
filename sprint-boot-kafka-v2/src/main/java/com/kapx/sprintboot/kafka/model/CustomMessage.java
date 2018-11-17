package com.kapx.sprintboot.kafka.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {
    private String type;
    private String message;
}
