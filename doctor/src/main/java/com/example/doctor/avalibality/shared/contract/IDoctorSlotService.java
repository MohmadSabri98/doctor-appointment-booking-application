package com.example.doctor.avalibality.shared.contract;

import com.example.doctor.avalibality.shared.dtos.DoctorSlotRequestDTO;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IDoctorSlotService {
     DoctorSlotResponseDTO addSlot(DoctorSlotRequestDTO requestDTO);
     List<DoctorSlotResponseDTO> listSlotsByDoctor(UUID doctorId);
     List<DoctorSlotResponseDTO> listFreeSlotsByDoctor(int page,int limit);
     List<DoctorSlotResponseDTO> listAllUpCommingSlotsByDoctorId(int page, int limit,UUID doctorId);
     DoctorSlotResponseDTO  getDoctorNameBySlotId(UUID slotId);
}
