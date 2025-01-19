package com.example.doctor.appointment.internal.infrastructure.Repository.impl;

import com.example.doctor.appointment.internal.application.eventHandlers.INotifyCreateAppointmentHandler;
import com.example.doctor.appointment.internal.domain.contract.IAppointment;
import com.example.doctor.appointment.internal.domain.model.Appointment;
import com.example.doctor.appointment.internal.infrastructure.Repository.IAppointmentRepo;
import com.example.doctor.appointment.internal.infrastructure.mapper.AppointmentToAppointmentEntityMapper;
import com.example.doctor.appointment.shared.dtos.AppointmentCreatedNotificationDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointment {
    private final IAppointmentRepo appointmentRepository;
    private final AppointmentToAppointmentEntityMapper mapper;
    private final INotifyCreateAppointmentHandler iNotifyCreateAppointmentHandler;
    @Override
    @Transactional
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save( mapper.map(appointment));
        AppointmentCreatedNotificationDto dto = new AppointmentCreatedNotificationDto(appointment.getSlotId(),appointment.getPatientName());
        iNotifyCreateAppointmentHandler.handle(dto);
    }
    @Override
    public List<Appointment> getAllDoctorUpCommingAppointment(int page, int limit, List<UUID> doctorSlotIds, LocalDateTime dateTime) {
        Pageable pageable = PageRequest.of(page, limit);

        return mapper.unMap(appointmentRepository.getAllDoctorUpCommingAppointment(pageable,dateTime,doctorSlotIds));
    }

    @Override
    public Appointment getAppointmentById(UUID appointmentId) {
        return mapper.unMap( appointmentRepository.findById(appointmentId));
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.save( mapper.map(appointment));

    }
}
