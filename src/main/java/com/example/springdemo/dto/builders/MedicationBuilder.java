package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.entities.Medication;

public class MedicationBuilder {
    public static Medication generateMedicationFromDTO(MedicationDTO medicationDTO){
        return new Medication(medicationDTO.getMedication_id(),
                medicationDTO.getName(),
                medicationDTO.getStart(),
                medicationDTO.getEnd(),
                medicationDTO.getSideEffects(),
                medicationDTO.getDosage(),
                medicationDTO.getId_patient());
    }

    public static MedicationDTO generateDTOFromMedication(Medication medication){
        return new MedicationDTO(medication.getMedication_id(),
                medication.getName(),
                medication.getStart(),
                medication.getEnd(),
                medication.getSideEffects(),
                medication.getDosage(),
                medication.getId_patient());
    }
}