package com.hms.api;

import com.hms.api.entity.Patient;
import com.hms.api.repository.PatientRepository;
import com.hms.api.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
        for (Patient p : patients) {
//            System.out.println("Patient: " + p.getId() + " - " + p.getFirstName() + " " + p.getLastName());
        }
    }

    @Test
    public void testPatientRepository2(){
        Patient p = patientService.getPatientById(1L);
        System.out.println(p);
    }

    @Test
    public void testPutPatient(){
        Patient p=new Patient();

    }
}
