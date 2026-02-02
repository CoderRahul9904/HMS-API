package com.hms.api.entity;

import com.hms.api.entity.type.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "staff")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String staffCode;

    private String lastName;
    private String department;
    private String designation;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDate joiningDate;

}