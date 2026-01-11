package com.hms.api.services.staff.Impl;

import com.hms.api.dto.staff.CreateStaffDto;
import com.hms.api.dto.staff.LoginStaffRequestDto;
import com.hms.api.dto.staff.LoginStaffResponseDto;
import com.hms.api.dto.user.CreateUserDto;
import com.hms.api.dto.user.UserResponseDto;
import com.hms.api.entity.Staff;
import com.hms.api.entity.User;
import com.hms.api.repository.StaffRepository;
import com.hms.api.services.staff.StaffImpl;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StaffService implements StaffImpl {

    private AuthenticationManager authenticationManager;
    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;

    public StaffService(StaffRepository staffRepository, ModelMapper modelMapper) {
        this.staffRepository = staffRepository;
        this.modelMapper = modelMapper;
    }

    public CreateStaffDto createStaff(String id,CreateStaffDto dto) {
        Staff staff=staffRepository.findByStaffCode(id).orElse(null);
        if(staff==null) throw new IllegalArgumentException("Staff not found");
        staff.setStaffCode(dto.getStaffCode());
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        staff.setRole(dto.getRole());
        staff.setDepartment(dto.getDepartment());
        return modelMapper.map(staffRepository.save(staff), CreateStaffDto.class);
    }



    @Override
    public LoginStaffResponseDto loginStaff(Long staffId) {


    }




}

