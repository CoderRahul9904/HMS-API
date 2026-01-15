package com.hms.api.controller.staff;

import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.services.staff.Impl.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginStaff {

    private final StaffService staffService;

    @PostMapping("/users/login/{staffCode}")
    public ResponseEntity<LoginStaffResponseDto> loginStaff(@PathVariable String staffCode,@RequestBody LoginStaffRequestDto loginStaffRequestDto) {
        return ResponseEntity.ok(staffService.loginStaff(staffCode, loginStaffRequestDto));
    }
}
