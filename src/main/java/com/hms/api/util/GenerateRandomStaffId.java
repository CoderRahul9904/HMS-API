package com.hms.api.util;

import com.hms.api.entity.type.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GenerateRandomStaffId {

    public String generateEmployeeCode(Role role, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID must not be null when generating staff code");
        }

        String prefix;
        switch (role) {
            case DOCTOR -> prefix = "D";
            case NURSE -> prefix = "N";
            case RECEPTIONIST -> prefix = "REC";
            case BILLER -> prefix = "B";
            case ADMIN -> prefix = "ADM";
            default -> prefix = "S";
        }

        return String.format("%s%05d", prefix, id);
    }
}
