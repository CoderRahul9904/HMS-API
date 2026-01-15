package com.hms.api.dto.staff;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginStaffResponseDto {
    private String token;
    private String staffCode;
}
