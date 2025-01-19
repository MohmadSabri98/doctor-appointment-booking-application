package com.example.doctor.appointment.internal.infrastructure.mapper;

import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorSlotResponseToDoctorAvailableSlotsMapper extends BaseMapper<com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO, DoctorSlotResponseDTO> {
}
