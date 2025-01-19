package com.example.doctor.appointment.internal.infrastructure.mapper;

import com.example.doctor.appointment.internal.application.command.Dtos.AppointmentResponseDTO;
import com.example.doctor.appointment.internal.infrastructure.Entities.AppointmentEntity;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentEntityToAppointmentResponceDtoMapper extends BaseMapper<AppointmentEntity, AppointmentResponseDTO> {
}
