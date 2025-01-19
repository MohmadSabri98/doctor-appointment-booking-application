package com.example.doctor.appointment.internal.infrastructure.Entities;


import com.example.doctor.appointment.internal.domain.model.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.UUID;

@Data
@Entity
@Table(schema = "appointment", name = "appointment")

public class AppointmentEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID slotId;

    @Column(nullable = false)
    private UUID patientId;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private LocalDateTime reservedAt;

    @Enumerated(EnumType.STRING)
    private Status status;
}
