package com.vank.eventManagement.Entity;

import com.vank.eventManagement.Entity.Enums.RefundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal refundAmount;

    @Enumerated(EnumType.STRING)
    private RefundStatus status;

    private String reason;

    private LocalDateTime refundDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false, unique = true)
    private Payment payment;
}
