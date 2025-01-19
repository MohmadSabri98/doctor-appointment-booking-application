package com.example.doctor.avalibality.internal.data.repositary;

import com.example.doctor.avalibality.internal.data.model.DoctorSlot;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorSlotRepository extends JpaRepository<DoctorSlot, UUID> {
    List<DoctorSlot> findByDoctorId(UUID doctorId);

    List<DoctorSlot> findByReservedIsFalse(Pageable pageable);

    @Query("""
            SELECT slot
            FROM DoctorSlot slot
            WHERE slot.doctorId = :doctorId
            AND  slot.isReserved = true
            AND slot.time >= :dateOfNow
            """)
    List<DoctorSlot> listAllUpCommingSlotsByDoctorId(Pageable pageable,@Param("doctorId") UUID doctorId,
                                                     @Param("dateOfNow") LocalDateTime dateOfNow);

    Optional<DoctorSlot> findById(UUID slotId);

}
