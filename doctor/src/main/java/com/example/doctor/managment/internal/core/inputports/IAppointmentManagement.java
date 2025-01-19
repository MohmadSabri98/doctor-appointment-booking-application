package com.example.doctor.managment.internal.core.inputports;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentStatusUpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public interface IAppointmentManagement {

     List<AppointmentApiResponseDTO> getAllUpcommingAppointment(int page, int limit, UUID doctorID) ;
     AppointmentResponseDTO updateAppointmentStatus(AppointmentStatusUpdateRequestDTO requestDTO);

}
