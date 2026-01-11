package com.hms.api.dto.staff;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginStaffResponseDto {
    private String token;
    private String staffCode;
}
