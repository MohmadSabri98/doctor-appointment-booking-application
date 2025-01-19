package com.example.doctor.avalibality.internal.application.mapper;

import com.example.doctor.avalibality.internal.data.model.DoctorSlot;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorSlotToResponseMapper extends BaseMapper<DoctorSlot, DoctorSlotResponseDTO> {
}
