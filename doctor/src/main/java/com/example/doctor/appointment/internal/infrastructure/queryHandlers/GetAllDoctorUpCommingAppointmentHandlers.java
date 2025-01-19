package com.example.doctor.appointment.internal.infrastructure.queryHandlers;

import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.DoctorSlotResponseDTO;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.GetAllDoctorSlotsQuery;
import com.example.doctor.appointment.internal.application.queries.getAllDoctorAvalibleSlots.IGetAllDoctorHandler;
import com.example.doctor.appointment.internal.infrastructure.gateway.DoctorSlotsGateway;
import com.example.doctor.shared.abstractions.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllDoctorUpCommingAppointmentHandlers implements QueryHandler<GetAllDoctorSlotsQuery, List<DoctorSlotResponseDTO>>
         {

    private final DoctorSlotsGateway doctorSlotsGateway;
    @Override
    public List<DoctorSlotResponseDTO> handle(GetAllDoctorSlotsQuery query) {
        return doctorSlotsGateway.getAllAppointments(query.page(), query.limit());
    }
}
