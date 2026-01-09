package com.hms.api.util;

import com.hms.api.entity.type.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GenerateRandomStaffId {

    private final JdbcTemplate jdbc;

    public GenerateRandomStaffId(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public long nextStaffSeq() {
        return jdbc.queryForObject("select nextval('staff_seq')", Long.class);
    }

    public String generateEmployeeCode(Role role) {
        long seq = nextStaffSeq();
        String prefix;

        switch (role) {
            case DOCTOR -> prefix = "D";
            case NURSE -> prefix = "N";
            case RECEPTIONIST -> prefix = "REC";
            case BILLER -> prefix = "B";
            case ADMIN -> prefix = "ADM";
            default -> prefix = "S";
        }

        return String.format("%s%05d", prefix, seq);
    }
}
