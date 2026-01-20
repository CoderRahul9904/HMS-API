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
public class CreateStaffController {

    private final StaffService staffService;
    @PostMapping("/users/create")
    public ResponseEntity<CreateStaffDto> registerStaffInfo(@AuthenticationPrincipal User user, @RequestBody CreateStaffDto createStaffDto) {
        System.out.println(user);
        return ResponseEntity.ok(staffService.createStaff(user,createStaffDto));
    }
}
