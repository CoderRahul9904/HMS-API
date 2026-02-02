package com.hms.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "staff_id", unique = true)
    private Staff staff;

    private String specialization;
    private String qualification;
    private Integer experienceYears;

    private String registrationNumber;

    private LocalDate joiningDate;

    private Boolean isActive = true;
}
