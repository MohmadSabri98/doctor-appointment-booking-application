package com.example.doctor.appointment.internal.infrastructure.eventHandlers;

import com.example.doctor.appointment.internal.application.eventHandlers.INotifyCreateAppointmentHandler;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;
import com.example.doctor.appointment.internal.infrastructure.gateway.DoctorSlotsGateway;
import com.example.doctor.appointment.shared.dtos.AppointmentCreatedNotificationDto;
import com.example.doctor.notification.shared.INotificationApis;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class NotifyCreateAppointmentHandler implements INotifyCreateAppointmentHandler {
    private final DoctorSlotsGateway doctorSlotsGateway;
    private final INotificationApis iNotificationApis;

    @Override
    public void handle(AppointmentCreatedNotificationDto dto) {
        DoctorSlotResponseDTO slotInfo = doctorSlotsGateway.getDoctorNameBySlotId(dto.getSlotId());
        dto.setMessage("Appointment date is: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "\n" +
                "Patient Name: " + dto.getPatientName() + "\n" +
                "Doctor Name: " + slotInfo.getDoctorName()
        );
        dto.setTo(slotInfo.getDoctorName());
        iNotificationApis.notify(dto); // sent notification to doctor
        dto.setTo(dto.getPatientName());
        iNotificationApis.notify(dto); // sent notification to doctor
    }
}
