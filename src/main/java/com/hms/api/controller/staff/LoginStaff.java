package com.hms.api.controller.staff;

import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.services.staff.Impl.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginStaff {

    private final StaffService staffService;

    @PostMapping("/users/login/{staffCode}")
    public ResponseEntity<LoginStaffResponseDto> loginStaff(@PathVariable String staffCode, LoginStaffRequestDto loginStaffRequestDto) {
        return ResponseEntity.ok(staffService.loginStaff(staffCode, loginStaffRequestDto));
    }
}
