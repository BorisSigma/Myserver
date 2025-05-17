package com.example.MyServer.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @Column(name = "userId")
    private final long userId;
    @Column(name = "eventName")
    private final String eventName;
    @Column(name = "eventDescription")
    private final String eventDescription;
    @Column(name = "eventLocation")
    private final String eventLocation;
    @Column(name = "category")
    private final String category;
    @Column(name = "eventUrl")
    private final String eventUrl;
    @Column(name = "eventUsername")
    private final String eventUsername;
    @Column(name = "event_stars_value")
    private final double event_stars_value;

}
