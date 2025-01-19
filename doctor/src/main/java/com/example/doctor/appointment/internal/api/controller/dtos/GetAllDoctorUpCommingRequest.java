package com.example.doctor.appointment.internal.api.controller.dtos;


import com.example.doctor.shared.abstractions.Request;

import java.time.LocalDateTime;

public record GetAllDoctorUpCommingRequest(int page, int limit, LocalDateTime dateTime) implements Request {
}