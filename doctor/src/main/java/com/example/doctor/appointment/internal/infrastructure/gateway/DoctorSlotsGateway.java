package com.example.doctor.appointment.internal.infrastructure.gateway;

import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;
import com.example.doctor.appointment.internal.infrastructure.mapper.DoctorSlotResponseToDoctorAvailableSlotsMapper;
import com.example.doctor.avalibality.shared.contract.IDoctorSlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DoctorSlotsGateway {
    private final IDoctorSlotService IDoctorSlotService;
    private  final DoctorSlotResponseToDoctorAvailableSlotsMapper doctorSlotResponseToDoctorAvailableSlotsMapper;


    public List<DoctorSlotResponseDTO> getAllAppointments(int page, int limit){
        return doctorSlotResponseToDoctorAvailableSlotsMapper
                .map(IDoctorSlotService.listFreeSlotsByDoctor(page, limit));
    }


    public DoctorSlotResponseDTO getDoctorNameBySlotId(UUID slotId){
        return  doctorSlotResponseToDoctorAvailableSlotsMapper
                .map(IDoctorSlotService.getDoctorNameBySlotId(slotId));
    }

}
