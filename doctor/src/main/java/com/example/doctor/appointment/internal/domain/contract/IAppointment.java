package com.example.doctor.appointment.internal.domain.contract;

import com.example.doctor.appointment.internal.domain.model.Appointment;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IAppointment {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllDoctorUpCommingAppointment(int page, int limit, List<UUID> doctorSlotIds, LocalDateTime dateTime);

    Appointment getAppointmentById(UUID appointmentId);
    void updateAppointment(Appointment appointment);


}
