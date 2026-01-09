package com.hms.api.services.user.Impl;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.entity.User;
import com.hms.api.repository.UserRepository;
import com.hms.api.services.user.UserImpl;
import com.hms.api.util.GenerateRandomStaffId;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserImpl {

    private final GenerateRandomStaffId generateRandomStaffId;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    public UserService(PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserRepository userRepository, GenerateRandomStaffId generateRandomStaffId
    ) {

        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.generateRandomStaffId = generateRandomStaffId;
    }

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByUsername(createUserDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        String passwordHash= passwordEncoder.encode(createUserDto.getPassword());
        User user=modelMapper.map(createUserDto, User.class);
        user.setPasswordHash(passwordHash);
        user.setStaffCode(generateRandomStaffId.generateEmployeeCode(user.getRole()));
        User actualUser=userRepository.save(user);
        return modelMapper.map(actualUser, UserResponseDto.class);
    }
}

