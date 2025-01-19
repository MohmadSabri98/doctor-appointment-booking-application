package com.example.doctor.managment.internal.shell.controllers;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus.AppointmentUpdateQueryDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentStatusUpdateRequestDTO;
import com.example.doctor.managment.internal.core.inputports.IAppointmentManagement;
import com.example.doctor.managment.internal.core.dtos.GetCommingAppointmentQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppointmentManagementController   {
    private final IAppointmentManagement iAppointmentManagement;
    @GetMapping("/upcomming-appointment")
    public ResponseEntity<List<AppointmentApiResponseDTO>> getAllUpcommingAppointment(@ModelAttribute GetCommingAppointmentQuery query) {
        return ResponseEntity.ok(
                iAppointmentManagement.getAllUpcommingAppointment(
                        query.page(),
                        query.limit(),
                        query.doctorId())
        );
    }


    @PutMapping("/update-appointment-status")
    public ResponseEntity<AppointmentResponseDTO> updateAppointmentStatus(@RequestBody AppointmentStatusUpdateRequestDTO requestDTO) {

        return ResponseEntity.ok(iAppointmentManagement.updateAppointmentStatus(requestDTO));

    }
}
