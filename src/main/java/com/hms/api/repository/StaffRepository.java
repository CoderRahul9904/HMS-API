package com.hms.api.repository;

import com.hms.api.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByStaffCode(String id);
}
