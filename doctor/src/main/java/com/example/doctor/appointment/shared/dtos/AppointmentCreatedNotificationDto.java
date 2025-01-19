package com.example.doctor.appointment.shared.dtos;

import com.example.doctor.notification.shared.dtos.NotificationDto;
import lombok.Data;

import java.util.UUID;

@Data
public class AppointmentCreatedNotificationDto extends NotificationDto {
private UUID slotId;

    public AppointmentCreatedNotificationDto(UUID slotId, String patientName) {
        this.slotId = slotId;
        this.patientName = patientName;
    }

    private String doctorName;
private String patientName;
}
