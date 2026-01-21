package com.hms.api.entity;
import com.hms.api.entity.type.AppointmentStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Staff doctor;

    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    private LocalDateTime createdAt;
}
