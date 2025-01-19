package com.example.doctor.managment.internal.core.service;

import com.example.doctor.appointment.shared.contracts.IAppointmentApi;
import com.example.doctor.appointment.shared.dtos.AppointmentApiResponseDTO;
import com.example.doctor.appointment.shared.dtos.AppointmentStatusUpdateRequestDTO;
import com.example.doctor.avalibality.shared.contract.IDoctorSlotService;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO;
import com.example.doctor.managment.internal.core.inputports.IAppointmentManagement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentManagementServiceImpl implements IAppointmentManagement {

private final IAppointmentApi iAppointmentApi;
private final IDoctorSlotService iDoctorSlotService;
    @Override
    public List<AppointmentApiResponseDTO> getAllUpcommingAppointment(int page, int limit, UUID doctorId) {
        List<DoctorSlotResponseDTO> slots=  iDoctorSlotService.listAllUpCommingSlotsByDoctorId(page,limit,doctorId);

        return iAppointmentApi.getAllDoctorUpCommingAppointment(page,limit,
                slots.stream().map(slot->slot.getId()).collect(Collectors.toList())
                , LocalDateTime.now());
    }

    @Override
    public AppointmentApiResponseDTO updateAppointmentStatus(AppointmentStatusUpdateRequestDTO requestDTO) {
        return iAppointmentApi.updateAppointmentStatus(requestDTO);
    }
}
