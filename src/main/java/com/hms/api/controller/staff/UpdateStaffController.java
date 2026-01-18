package com.hms.api.controller.staff;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.entity.User;
import com.hms.api.services.staff.Impl.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UpdateStaffController {

    private final StaffService staffService;

    @PutMapping("/users/update/")
    public ResponseEntity<CreateStaffDto> createStaffInfo(@AuthenticationPrincipal User user, @RequestBody CreateStaffDto createStaffDto) {
        return ResponseEntity.ok(staffService.createStaff(user,createStaffDto));
    }



}
