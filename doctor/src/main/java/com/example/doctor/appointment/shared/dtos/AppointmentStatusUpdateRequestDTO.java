package com.example.doctor.appointment.shared.dtos;


import com.example.doctor.shared.abstractions.Command;
import lombok.Data;

import java.util.UUID;

@Data
public class AppointmentStatusUpdateRequestDTO implements Command {

    private UUID AppointmentId;
    private String status;
}
