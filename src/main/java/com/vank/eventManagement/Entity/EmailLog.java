package com.vank.eventManagement.Entity;

import com.vank.eventManagement.Entity.Enums.EmailStatus;
import com.vank.eventManagement.Entity.Enums.EmailType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="email_logs")
public class EmailLog {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String reciepientEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmailType emailType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmailStatus status;

    @Column(length = 2000)
    private String errorMessage;

    @Column(nullable = false)
    private LocalDateTime sentAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
