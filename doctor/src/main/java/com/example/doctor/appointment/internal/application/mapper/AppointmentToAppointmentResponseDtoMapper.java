package com.example.doctor.appointment.internal.application.mapper;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.domain.model.Appointment;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentToAppointmentResponseDtoMapper extends BaseMapper<Appointment, AppointmentResponseDTO> {
}
