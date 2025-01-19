package com.example.doctor.appointment.internal.application.queries.getAllDoctorUpCommingAppointments;

import com.example.doctor.shared.abstractions.Query;

import java.time.LocalDateTime;

public record AllDoctorUpCommingAppointmentQuery(int page , int limit, LocalDateTime localDateTime) implements Query {
}