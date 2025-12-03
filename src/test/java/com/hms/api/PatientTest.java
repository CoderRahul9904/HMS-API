package com.hms.api;

import com.hms.api.entities.Patient;
import com.hms.api.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;
    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
        for (Patient p : patients) {
            System.out.println("Patient: " + p.getId() + " - " + p.getFirstName() + " " + p.getLastName());
        }
    }
}
