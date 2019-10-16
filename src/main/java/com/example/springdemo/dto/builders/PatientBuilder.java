package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Patient;

public class PatientBuilder {

    public static PatientDTO generateDTOFromPatient(Patient patient)
    {
        return new PatientDTO(patient.getPatient_id(),
                patient.getId_caregiver(),
                patient.getName(),
                patient.getBirthDate(),
                patient.getGender(),
                patient.getMedicalRecord());
    }

    public static Patient generatePatientFromDTO(PatientDTO patientDTO)
    {
        return new Patient(patientDTO.getPatient_id(),
                patientDTO.getId_caregiver(),
                patientDTO.getName(),
                patientDTO.getBirthDate(),
                patientDTO.getGender(),
                patientDTO.getMedicalRecord());
    }
}
