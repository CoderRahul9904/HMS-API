package com.hms.api.controller.staff;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.services.staff.Impl.StaffService;
import com.hms.api.services.staff.StaffImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class CreateStaffController {

    private final StaffService staffService;
    @PostMapping("/users/create/{userId}")
    public ResponseEntity<CreateStaffDto> registerStaffInfo(@PathVariable String userId, @RequestBody CreateStaffDto createStaffDto) {
        return ResponseEntity.ok(staffService.createStaff(userId,createStaffDto));
    }
}
