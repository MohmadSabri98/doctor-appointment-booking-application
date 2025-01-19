package com.example.doctor.appointment.shared.mapper;

import com.example.doctor.appointment.internal.domain.model.Appointment;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentToAppointmentApiResponseDtoMapper extends BaseMapper<Appointment, AppointmentApiResponseDTO> {
}
