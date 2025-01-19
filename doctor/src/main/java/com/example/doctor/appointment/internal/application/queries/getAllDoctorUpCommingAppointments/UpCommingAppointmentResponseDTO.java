package com.example.doctor.appointment.internal.application.queries.getAllDoctorUpCommingAppointments;


import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UpCommingAppointmentResponseDTO {
    private UUID id;
    private UUID slotId;
    private UUID patientId;
    private String patientName;
    private Date reservedAt;
}
