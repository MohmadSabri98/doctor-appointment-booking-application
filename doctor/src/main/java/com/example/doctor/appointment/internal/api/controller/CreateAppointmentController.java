package com.example.doctor.appointment.internal.api.controller;

import com.example.doctor.appointment.internal.api.controller.dtos.AppointmentRequestDTO;
import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.command.createApoppointment.AppointmentCreateQueryDTO;
import com.example.doctor.appointment.internal.application.command.createApoppointment.CreateAppointmentHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class CreateAppointmentController {
    private final CreateAppointmentHandler createAppointmentHandler;

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> bookAppointment(@RequestBody AppointmentRequestDTO requestDTO) {
        AppointmentCreateQueryDTO query = new AppointmentCreateQueryDTO(
                requestDTO.getSlotId(),
                requestDTO.getPatientId(),
                requestDTO.getPatientName()
        );
        return ResponseEntity.ok(createAppointmentHandler.handle(query));

    }
}
