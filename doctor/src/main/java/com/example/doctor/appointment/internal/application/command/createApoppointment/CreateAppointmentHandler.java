package com.example.doctor.appointment.internal.application.command.createApoppointment;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.application.mapper.AppointmentToAppointmentResponseDtoMapper;
import com.example.doctor.appointment.internal.domain.contract.IAppointment;
import com.example.doctor.appointment.internal.domain.model.Appointment;
import com.example.doctor.appointment.internal.domain.model.Status;
import com.example.doctor.shared.abstractions.CommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateAppointmentHandler extends CommandHandler<AppointmentCreateQueryDTO, AppointmentResponseDTO> {
    private final AppointmentToAppointmentResponseDtoMapper mapper;
    private final IAppointment iAppointment;


    @Override
    public AppointmentResponseDTO handle(AppointmentCreateQueryDTO command) {

            var appointment = Appointment.createAppointment(
                    command.getSlotId(),
                    command.getPatientId(),
                    command.getPatientName(),
                    LocalDateTime.now(),
                    Status.NEW);

            iAppointment.saveAppointment(appointment);
            return mapper.map(appointment);

    }
}
