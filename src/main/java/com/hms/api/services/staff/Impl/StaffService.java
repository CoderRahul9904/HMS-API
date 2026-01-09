package com.hms.api.services.staff.Impl;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.services.staff.StaffImpl;
import org.springframework.stereotype.Service;

@Service
public class StaffService implements StaffImpl {

    @Override
    public UserResponseDto registerUser(CreateUserDto createUserDto) {
        return null;
    }

}
