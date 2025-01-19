package com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots;

import com.example.doctor.shared.abstractions.Query;

public record GetAllDoctorSlotsQuery(int page , int limit) implements Query {
}