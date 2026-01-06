package com.hms.api.dto.user;
import com.hms.api.entity.type.Role;
import lombok.Data;

@Data
public class UpdateUserDto {

    private String email;
    private String fullName;
    private Boolean isActive;
    private Role role;
}
