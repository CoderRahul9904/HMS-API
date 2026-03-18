package com.hms.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "insurance",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "policyNumber")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String providerName;

    @Column(nullable = false, length = 50)
    private String policyNumber;

    @Column(nullable = false)
    private Double coverageAmount;

    private String expiryDate;

}