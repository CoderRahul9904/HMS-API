package com.hms.api.dto.staff;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginStaffRequestDto {
    private String username;
    private String password;
}
