package com.example.doctor.appointment.shared.contracts;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentStatusUpdateRequestDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IAppointmentApi {
    List<AppointmentApiResponseDTO> getAllDoctorUpCommingAppointment(int page, int limit, List<UUID> doctorSlotIds, LocalDateTime dateTime);
    AppointmentResponseDTO updateAppointmentStatus(AppointmentStatusUpdateRequestDTO requestDTO);
}
