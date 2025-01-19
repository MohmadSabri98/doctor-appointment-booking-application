package com.example.doctor.managment.internal.core.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetCommingAppointmentQuery(int page, int limit, UUID doctorId, LocalDateTime localDateTime) {
}