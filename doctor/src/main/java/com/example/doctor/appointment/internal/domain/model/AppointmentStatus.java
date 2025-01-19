package com.example.doctor.appointment.internal.domain.model;


import com.example.doctor.appointment.internal.domain.Exception.AppointmentAlreadyCancelledException;
import com.example.doctor.appointment.internal.domain.Exception.AppointmentAlreadyCompleted;

public record AppointmentStatus(Status value) {

    public static AppointmentStatus of(Status status) {
        return new AppointmentStatus(status);
    }

    public AppointmentStatus cancel() {
        if (isCancelled()) {
            throw new AppointmentAlreadyCancelledException();
        }
        return new AppointmentStatus(Status.CANCELLED);
    }

    public AppointmentStatus complete() {
        if (isCompleted()) {
            throw new AppointmentAlreadyCompleted();
        }
        return new AppointmentStatus(Status.COMPLETED);
    }

    public boolean isCancelled() {
        return value == Status.CANCELLED;
    }

    public boolean isCompleted() {
        return value == Status.COMPLETED;
    }

}