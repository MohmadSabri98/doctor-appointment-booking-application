package com.example.doctor.appointment.shared.dtos;


import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AppointmentApiResponseDTO {
    private UUID id;
    private UUID slotId;
    private UUID patientId;
    private String patientName;
    private Date reservedAt;
}
