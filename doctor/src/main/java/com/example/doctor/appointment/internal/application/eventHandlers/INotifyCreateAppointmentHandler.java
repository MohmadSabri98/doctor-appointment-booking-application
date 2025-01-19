package com.example.doctor.appointment.internal.application.eventHandlers;


import com.example.doctor.appointment.shared.dtos.AppointmentCreatedNotificationDto;

public interface INotifyCreateAppointmentHandler {


    void handle(AppointmentCreatedNotificationDto appointment);

}
