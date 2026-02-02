package com.hms.api.entity;

import com.hms.api.entity.type.BloodGroupType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    private LocalDate dateOfBirth;

    private String gender;
    private String phonePrimary;

    @Email
    private String email;

    private String addressLine1;
    private String nationalIdType;

    @Column(unique = true)
    private String nationalId;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroupType;

    private String emergencyContactName;

    private String emergencyContactPhone;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy ="patient")
    private List<Appointment> appointments;

    @Version
    private Integer version;
    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
