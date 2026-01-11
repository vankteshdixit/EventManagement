package com.vank.eventManagement.Entity;

import com.vank.eventManagement.Entity.Enums.EventStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private Integer totalSeats;

    private Integer availableSeats;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    private LocalDateTime createdAt = LocalDateTime.now();

//  organizer of the event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;

    @OneToMany(mappedBy="event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;
}