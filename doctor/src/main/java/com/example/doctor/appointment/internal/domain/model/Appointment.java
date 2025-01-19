package com.example.doctor.appointment.internal.domain.model;


import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private UUID id;

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    private UUID slotId;
    private UUID patientId;
    private String patientName;
    private LocalDateTime reservedAt;
     private  AppointmentStatus appointmentStatus;

//    private ArrayList<CaseEvent> occurredEvents = new ArrayList<>();
//
//    public List<CaseEvent> getOccurredEvents() {
//        var events = new ArrayList<>(this.occurredEvents);
//        this.occurredEvents.clear();
//        return events;
//    }


    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public Appointment(UUID slotId, UUID patientId, String patientName, LocalDateTime reservedAt, AppointmentStatus appointmentStatus) {
        this.id = UUID.randomUUID();
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
        this.appointmentStatus = appointmentStatus;
    }
    public static Appointment createAppointment(UUID slotId,
                                                UUID patientId,
                                                String patientName,
                                                LocalDateTime reservedAt,
                                                Status status) {

        return new Appointment(slotId, patientId, patientName, reservedAt, AppointmentStatus.of(status));
    }

    public void complete() {
        this.appointmentStatus = appointmentStatus.complete();
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void close() {
        this.appointmentStatus = appointmentStatus.cancel();
    }

    public void updateAppointmentStatus(Status status){
        switch (status){
            case CANCELLED -> {this.setAppointmentStatus(this.appointmentStatus.cancel());
            }
            case COMPLETED -> {this.setAppointmentStatus(this.appointmentStatus.complete());
            }
        }
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }
}
