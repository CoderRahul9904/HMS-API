package com.hms.api.services.user.Impl;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.entity.User;
import com.hms.api.entity.type.Role;
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
    public UserResponseDto createUser(CreateUserDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = modelMapper.map(dto, User.class);
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user = userRepository.save(user);
        if (user.getRole() != Role.PATIENT) {
            user.setStaffCode(
                    generateRandomStaffId.generateEmployeeCode(
                            user.getRole(),
                            user.getId()
                    )
            );
        }
        return modelMapper.map(user, UserResponseDto.class);
    }
}

