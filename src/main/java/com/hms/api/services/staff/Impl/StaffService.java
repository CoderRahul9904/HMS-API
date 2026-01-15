package com.hms.api.services.staff.Impl;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.entity.Staff;
import com.hms.api.entity.User;
import com.hms.api.repository.StaffRepository;
import com.hms.api.services.staff.StaffImpl;
import com.hms.api.util.GenerateTokenUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffService implements StaffImpl {

    private final AuthenticationManager authenticationManager;
    private final GenerateTokenUtil generateTokenUtil;
    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;


    public CreateStaffDto createStaff(String id,CreateStaffDto dto) {
        Staff staff=modelMapper.map(dto, Staff.class);
        staff.setStaffCode(id);
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        staff.setRole(dto.getRole());
        staff.setDepartment(dto.getDepartment());
        return modelMapper.map(staffRepository.save(staff), CreateStaffDto.class);
    }



    @Override
    public LoginStaffResponseDto loginStaff(String staffCode, LoginStaffRequestDto dto) {
        if(staffRepository.findByStaffCode(staffCode).isEmpty()) throw new IllegalArgumentException("Staff not found");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        User user=(User) authentication.getPrincipal();

        String token=generateTokenUtil.generateJwtAccessToken(user);
        return new LoginStaffResponseDto(token, user.getStaffCode());
    }



}

