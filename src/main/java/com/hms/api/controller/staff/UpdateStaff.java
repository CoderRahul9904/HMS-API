package com.hms.api.controller.staff;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.entity.Staff;
import com.hms.api.services.staff.Impl.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UpdateStaff {

    private final StaffService staffService;

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<CreateStaffDto> createStaffInfo(@PathVariable String userId, @RequestBody CreateStaffDto createStaffDto) {
        return ResponseEntity.ok(staffService.createStaff(userId,createStaffDto));
    }

    @PostMapping("/users/create/{userId}")
    public ResponseEntity<CreateStaffDto> registerStaffInfo(@PathVariable String userId, @RequestBody CreateStaffDto createStaffDto) {
        return ResponseEntity.ok(staffService.createStaff(userId,createStaffDto));
    }

    @PostMapping("/users/login/{staffId}")
    public ResponseEntity<LoginStaffResponseDto> loginStaff(@PathVariable Long staffId) {
        return ResponseEntity.ok(staffService.)
    }
}
