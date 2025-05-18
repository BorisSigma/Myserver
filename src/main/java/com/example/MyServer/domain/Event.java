package com.example.MyServer.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
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
