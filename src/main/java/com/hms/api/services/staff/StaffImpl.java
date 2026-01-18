package com.hms.api.services.staff;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.entity.Staff;
import com.hms.api.entity.User;

public interface StaffImpl {
    CreateStaffDto createStaff(User user, CreateStaffDto createStaffDto);
    LoginStaffResponseDto loginStaff(LoginStaffRequestDto dto);

}
