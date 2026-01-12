package com.hms.api.dto.staff;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginStaffResponseDto {
    private String token;
    private String staffCode;

    public LoginStaffResponseDto(String token, Long id) {
        this.token = token;
        this.staffCode = String.valueOf(id);
    }
}
