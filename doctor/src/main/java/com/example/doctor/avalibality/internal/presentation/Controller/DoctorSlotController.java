package com.example.doctor.avalibality.internal.presentation.Controller;


import com.example.doctor.avalibality.shared.contract.IDoctorSlotService;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotRequestDTO;
import com.example.doctor.avalibality.shared.dtos.DoctorSlotResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/slots")
@AllArgsConstructor
public class DoctorSlotController {

    private final IDoctorSlotService service;

    @PostMapping
    public ResponseEntity<DoctorSlotResponseDTO> createSlot(@RequestBody DoctorSlotRequestDTO requestDTO) {
        DoctorSlotResponseDTO responseDTO = service.addSlot(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<DoctorSlotResponseDTO>> getSlotsByDoctor(@RequestParam(name="Id") UUID doctorId) {
        List<DoctorSlotResponseDTO> slots = service.listSlotsByDoctor(doctorId);
        return ResponseEntity.ok(slots);
    }
}
