package com.example.MyServer.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDto {
    private Long userId;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String category;
    private String eventUrl;
    private String eventUsername;
    private double eventStarsValue;
}