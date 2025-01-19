package com.example.doctor.appointment.internal.api.controller.dtos;


import com.example.doctor.shared.abstractions.Command;
import lombok.Data;

import java.util.UUID;

@Data
public class AppointmentRequestDTO implements Command {
    private UUID slotId;
    private UUID patientId;
    private String patientName;
}
