package com.hms.api.dto.user;

import com.hms.api.entity.type.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;
    private String fullName;
    private Role role;
}
