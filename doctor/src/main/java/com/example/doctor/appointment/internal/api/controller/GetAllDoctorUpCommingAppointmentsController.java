package com.example.doctor.appointment.internal.api.controller;

import com.example.doctor.appointment.internal.api.controller.dtos.GetAllDoctorSlotsRequest;
import com.example.doctor.appointment.internal.api.controller.dtos.GetAllDoctorUpCommingRequest;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.GetAllDoctorSlotsQuery;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.IGetAllDoctorHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/up-comming-appointments")
@AllArgsConstructor
public class GetAllDoctorUpCommingAppointmentsController {
    private final IGetAllDoctorHandler iGetAllDoctorHandler;


    @GetMapping
    public ResponseEntity<List<DoctorSlotResponseDTO>> getAllAppointments(@ModelAttribute GetAllDoctorUpCommingRequest requestDTO) {
        GetAllDoctorSlotsQuery query = new GetAllDoctorSlotsQuery(requestDTO.page(), requestDTO.limit());
        return ResponseEntity.ok(iGetAllDoctorHandler.handle(query));
    }
}
