package com.example.doctor.appointment.internal.domain.model;

public enum Status {
    COMPLETED, CANCELLED;
    public static Status fromString(String status) {
        return valueOf(status.toUpperCase());
    }

     Status() {
    }
}
