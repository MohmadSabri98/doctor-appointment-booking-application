package com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.mapper.AppointmentToAppointmentResponseDtoMapper;
import com.example.doctor.appointment.internal.domain.contract.IAppointment;
import com.example.doctor.appointment.internal.domain.model.Status;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.mapper.AppointmentToAppointmentApiResponseDtoMapper;
import com.example.doctor.shared.abstractions.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAppointmentStatusHandler extends CommandHandler<AppointmentUpdateQueryDTO, AppointmentApiResponseDTO> {
    private final AppointmentToAppointmentApiResponseDtoMapper mapper;
    private final IAppointment iAppointment;


    @Override
    public AppointmentApiResponseDTO handle(AppointmentUpdateQueryDTO command) {
            var appointment = iAppointment.getAppointmentById(command.getAppointmentId());
                appointment.updateAppointmentStatus(Status.fromString(command.getStatus()));
             iAppointment.updateAppointment(appointment);
            return mapper.map(appointment);

    }
}
