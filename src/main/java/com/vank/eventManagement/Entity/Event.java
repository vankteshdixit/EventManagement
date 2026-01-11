package com.vank.eventManagement.Entity;

import com.vank.eventManagement.Entity.Enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BookingStatus status;
}
