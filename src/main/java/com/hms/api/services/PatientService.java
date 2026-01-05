package com.hms.api.services;

import com.hms.api.entities.Patient;
import com.hms.api.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(long id) {
        Patient patient1 = patientRepository.findById(id).get();
        Patient patient2 = patientRepository.findById(id).get();

        System.out.println(patient1);

        patient1.setFirstName("Rahul");

        return patient1;
    }
}
