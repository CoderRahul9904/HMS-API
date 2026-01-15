package com.hms.api.dto.staff;

import com.hms.api.entity.type.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStaffDto {
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private Role role;
}
