package com.hms.api.dto.staff;

import com.hms.api.entity.type.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class CreateStaffDto {
    private Long id;
    private String staffCode;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private Role role;
}
