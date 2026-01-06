package com.hms.api.services.user.Impl;

import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.entity.User;
import com.hms.api.repository.UserRepository;
import com.hms.api.services.user.UserImpl;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    public UserServiceImpl(PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(CreateUserDto createUserDto) {
        if (userRepository.existsByUsername(createUserDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        String passwordHash= passwordEncoder.encode(createUserDto.getPassword());
        User user=modelMapper.map(createUserDto, User.class);
        user.setPasswordHash(passwordHash);
        User actualUser=userRepository.save(user);
        return modelMapper.map(actualUser, UserResponseDto.class);
    }
}

