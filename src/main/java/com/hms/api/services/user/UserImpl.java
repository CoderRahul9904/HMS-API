package com.hms.api.services.user;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;

public interface UserImpl {
    UserResponseDto createUser(CreateUserDto createUserDto);
}
