package com.hms.api.dto.user;

import com.hms.api.entity.type.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class LoginUserResponseDto {
    private String token;
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
