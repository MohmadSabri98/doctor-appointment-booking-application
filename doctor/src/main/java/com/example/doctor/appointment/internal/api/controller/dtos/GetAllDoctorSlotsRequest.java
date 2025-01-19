package com.example.doctor.appointment.internal.api.controller.dtos;


import com.example.doctor.shared.abstractions.Request;

public record GetAllDoctorSlotsRequest(int page, int limit) implements Request {

}