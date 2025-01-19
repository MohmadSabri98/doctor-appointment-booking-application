package com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots;


import java.util.List;

public interface IGetAllDoctorHandler {
    List<DoctorSlotResponseDTO> handle(GetAllDoctorSlotsQuery query);
}
