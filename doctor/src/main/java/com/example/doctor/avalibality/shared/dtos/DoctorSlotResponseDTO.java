package com.example.doctor.avalibality.shared.dtos;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DoctorSlotResponseDTO {

    private UUID id;
    private LocalDateTime time;
    private UUID doctorId;
    private String doctorName;
    private boolean isReserved;
    private double cost;

}
