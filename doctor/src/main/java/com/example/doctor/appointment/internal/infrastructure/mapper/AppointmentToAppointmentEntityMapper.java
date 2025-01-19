package com.example.doctor.appointment.internal.infrastructure.mapper;

import com.example.doctor.appointment.internal.domain.model.Appointment;
import com.example.doctor.appointment.internal.domain.model.AppointmentStatus;
import com.example.doctor.appointment.internal.infrastructure.Entities.AppointmentEntity;
import com.example.doctor.shared.baseMapper.BaseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface AppointmentToAppointmentEntityMapper extends BaseMapper<Appointment, AppointmentEntity> {
    @AfterMapping
   default Appointment fromAppointmentEntityToAppointmentDomainModel(@MappingTarget Appointment model, AppointmentEntity entity){
        model.setAppointmentStatus(AppointmentStatus.of(entity.getStatus()));
        return model;
    }

    @AfterMapping
    default AppointmentEntity   fromAppointmentDomainModelToAppointmentEntity( Appointment model,@MappingTarget AppointmentEntity entity){
        entity.setStatus(model.getAppointmentStatus().value());
        return entity;
    }
}
