package com.hms.api.entity;

import com.hms.api.entity.type.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users",
        indexes = {@Index(name = "idx_users_username", columnList = "username")})
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false, length = 100)
    private String username;

    @JsonIgnore
    @ToString.Exclude
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Email
    @Column(length = 255)
    private String email;

    @Column(name = "full_name", length = 200)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(length = 32, nullable = false)
    private Role role = Role.PATIENT;

    @Column(name = "staff_code")
    private String staffCode;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_" + role.name());
    }

    @Override
    public @Nullable String getPassword() {
        return passwordHash;
    }
}
