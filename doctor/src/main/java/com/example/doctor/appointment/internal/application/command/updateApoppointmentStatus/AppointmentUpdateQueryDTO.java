package com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus;


import com.example.doctor.shared.abstractions.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AppointmentUpdateQueryDTO implements Command {

    private UUID AppointmentId;
    private String status;
}
