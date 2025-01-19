package com.example.doctor.avalibality.internal.application.impl;

import com.example.doctor.avalibality.shared.contract.IDoctorSlotService;
import com.example.doctor.avalibality.internal.application.mapper.DoctorSlotToRequestMapper;
import com.example.doctor.avalibality.internal.application.mapper.DoctorSlotToResponseMapper;
import com.example.doctor.avalibality.internal.data.model.DoctorSlot;
import com.example.doctor.avalibality.internal.data.repositary.DoctorSlotRepository;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotRequestDTO;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorSlotServiceImpl implements IDoctorSlotService {

    private final DoctorSlotRepository doctorSlotRepository;
    private final DoctorSlotToResponseMapper mapToResponse;
    private final DoctorSlotToRequestMapper mapToRequest;


    @Override
    public DoctorSlotResponseDTO addSlot(DoctorSlotRequestDTO requestDTO) {
        DoctorSlot doctorSlot = mapToRequest.unMap(requestDTO);
        doctorSlot.setId(UUID.randomUUID());
        DoctorSlot savedSlot = doctorSlotRepository.save(doctorSlot);
        return mapToResponse.map(savedSlot);
    }


    @Override
    public List<DoctorSlotResponseDTO> listSlotsByDoctor(UUID doctorId) {
        List<DoctorSlot> slots = doctorSlotRepository.findByDoctorId(doctorId);
        return slots.stream()
                .map(mapToResponse::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorSlotResponseDTO> listFreeSlotsByDoctor(int page, int limit)   {
        Pageable pageable = PageRequest.of(page, limit);
        List<DoctorSlot> slots = doctorSlotRepository.findByReservedIsFalse(pageable);
        return slots.stream()
                .map(mapToResponse::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorSlotResponseDTO> listAllUpCommingSlotsByDoctorId(int page, int limit,UUID doctorId) {
        Pageable pageable = PageRequest.of(page, limit);
        List<DoctorSlot> slots = doctorSlotRepository.listAllUpCommingSlotsByDoctorId(pageable,doctorId, LocalDateTime.now());
        return slots.stream()
                .map(mapToResponse::map)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorSlotResponseDTO getDoctorNameBySlotId(UUID slotId) {
        return (DoctorSlotResponseDTO) Optional.ofNullable(doctorSlotRepository.findByDoctorId(slotId)).map(mapToResponse::map).orElse(null);
    }
}
