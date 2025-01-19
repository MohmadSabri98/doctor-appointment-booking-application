package com.example.doctor.appointment.internal.infrastructure.Repository;

import com.example.doctor.appointment.internal.infrastructure.Entities.AppointmentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface IAppointmentRepo extends JpaRepository<AppointmentEntity, Long> {

    @Query("""
           SELECT app
           FROM AppointmentEntity app
           WHERE  app.reservedAt >= :dateOfNow
           And app.slotId in (:doctorSlotIds)
""")
    List<AppointmentEntity> getAllDoctorUpCommingAppointment(Pageable pageable, @Param("dateOfNow")LocalDateTime dateTime,@Param("doctorSlotIds") List<UUID> doctorSlotIds);

      AppointmentEntity findById(UUID id);
}
