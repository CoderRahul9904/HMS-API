package com.hms.api.dto.user;

import com.hms.api.entity.type.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private String fullName;
    private Role role;
    private Boolean isActive;
    private Long staffId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
