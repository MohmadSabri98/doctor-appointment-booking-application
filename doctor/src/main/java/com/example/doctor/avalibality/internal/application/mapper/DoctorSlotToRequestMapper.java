package com.example.doctor.avalibality.internal.application.mapper;

import com.example.doctor.avalibality.internal.data.model.DoctorSlot;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotRequestDTO;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorSlotToRequestMapper extends BaseMapper<DoctorSlot, DoctorSlotRequestDTO> {
}
