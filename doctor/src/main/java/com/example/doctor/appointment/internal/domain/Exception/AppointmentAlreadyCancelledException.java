package com.example.doctor.appointment.internal.domain.Exception;


import com.example.doctor.shared.Exceptions.BusinessRuleException;

public class AppointmentAlreadyCancelledException extends BusinessRuleException {

    public AppointmentAlreadyCancelledException() {
        super("appointment is already cancelled");
    }
}