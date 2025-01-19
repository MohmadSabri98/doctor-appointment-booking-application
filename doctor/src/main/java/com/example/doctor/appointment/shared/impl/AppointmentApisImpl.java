package com.example.doctor.appointment.shared.impl;

import com.example.doctor.appointment.internal.api.controller.dtos.AppointmentRequestDTO;
import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus.AppointmentUpdateQueryDTO;
import com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus.UpdateAppointmentStatusHandler;
import com.example.doctor.appointment.internal.infrastructure.Repository.impl.AppointmentService;
import com.example.doctor.appointment.shared.contracts.IAppointmentApi;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentStatusUpdateRequestDTO;
import com.example.doctor.appointment.shared.mapper.AppointmentToAppointmentApiResponseDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AppointmentApisImpl  implements IAppointmentApi {
    private final AppointmentToAppointmentApiResponseDtoMapper mapper;
    private final AppointmentService appointmentService;
    private final UpdateAppointmentStatusHandler updateAppointmentStatusHandler;
    @Override
    public List<AppointmentApiResponseDTO> getAllDoctorUpCommingAppointment(int page, int limit, List<UUID> doctorSlotIds, LocalDateTime dateTime) {
        return mapper.map(appointmentService.getAllDoctorUpCommingAppointment(page, limit,doctorSlotIds, dateTime));
    }

    @Override
    public AppointmentApiResponseDTO updateAppointmentStatus(AppointmentStatusUpdateRequestDTO requestDTO) {
        AppointmentUpdateQueryDTO query = new AppointmentUpdateQueryDTO(
                requestDTO.getAppointmentId(),
                requestDTO.getStatus()
        );
        return updateAppointmentStatusHandler.handle(query);
    }
}
