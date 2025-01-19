package com.example.doctor.appointment.internal.application.command.updateApoppointmentStatus;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.mapper.AppointmentToAppointmentResponseDtoMapper;
import com.example.doctor.appointment.internal.domain.contract.IAppointment;
import com.example.doctor.appointment.internal.domain.model.Status;
import com.example.doctor.shared.abstractions.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAppointmentStatusHandler extends CommandHandler<AppointmentUpdateQueryDTO, AppointmentResponseDTO> {
    private final AppointmentToAppointmentResponseDtoMapper mapper;
    private final IAppointment iAppointment;


    @Override
    public AppointmentResponseDTO handle(AppointmentUpdateQueryDTO command) {
            var appointment = iAppointment.getAppointmentById(command.getAppointmentId());
                appointment.updateAppointmentStatus(Status.fromString(command.getStatus()));
             iAppointment.updateAppointment(appointment);
            return mapper.map(appointment);

    }
}
