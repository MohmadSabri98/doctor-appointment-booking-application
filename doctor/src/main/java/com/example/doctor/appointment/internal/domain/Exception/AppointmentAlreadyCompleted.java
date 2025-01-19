package com.example.doctor.appointment.internal.domain.Exception;


import com.example.doctor.shared.Exceptions.BusinessRuleException;

import java.util.UUID;

public class AppointmentAlreadyCompleted extends BusinessRuleException {

    public AppointmentAlreadyCompleted() {
        super("appointment is already completed");
    }
}