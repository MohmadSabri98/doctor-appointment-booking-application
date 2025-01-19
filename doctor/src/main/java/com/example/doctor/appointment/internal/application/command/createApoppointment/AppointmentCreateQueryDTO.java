package com.example.doctor.appointment.internal.application.command.createApoppointment;


import com.example.doctor.shared.abstractions.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AppointmentCreateQueryDTO implements Command {
    private UUID slotId;
    private UUID patientId;
    private String patientName;
}
