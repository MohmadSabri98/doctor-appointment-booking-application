package com.example.doctor.appointment.internal.application.queries.getAllDoctorUpCommingAppointments;


import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;

import java.util.List;

public interface IGetAllDoctorUpCommingAppointmentHandler {
    List<AllDoctorUpCommingAppointmentQuery> handle(AllDoctorUpCommingAppointmentQuery query);
}
