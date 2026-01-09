package com.hms.api.services.staff;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;

public interface StaffImpl {
    UserResponseDto registerUser(CreateUserDto createUserDto);
}
