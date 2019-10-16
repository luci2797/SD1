package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.builders.MedicationBuilder;
import com.example.springdemo.entities.Medication;
import com.example.springdemo.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }

    public List<MedicationDTO> getAll(){
        ArrayList<MedicationDTO> medicationDTOS = new ArrayList<MedicationDTO>();

        for (Medication m:medicationRepository.getAll()){
            medicationDTOS.add(MedicationBuilder.generateDTOFromMedication(m));
        }
        return medicationDTOS;
    }

    public MedicationDTO findById(Integer id){
        return MedicationBuilder.generateDTOFromMedication(medicationRepository.getMedicationById(id));
    }

    public List<MedicationDTO> findByPatientId(Integer patientId){
        ArrayList<MedicationDTO> medicationDTOS = new ArrayList<MedicationDTO>();

        for (Medication m:medicationRepository.getMedicationByPatientId(patientId)){
            medicationDTOS.add(MedicationBuilder.generateDTOFromMedication(m));
        }
        return medicationDTOS;
    }

    public Boolean deleteById(Integer id){
        if (this.findById(id) == null){
            System.out.println("medication with specified id does not exist");
            return false;
        }
        else {
            medicationRepository.deleteById(id);
            return true;
        }
    }

    public Boolean update(MedicationDTO medicationDTO){
        if (this.findById(medicationDTO.getMedication_id()) == null){
            System.out.println("medication with specified id does not exist");
            return false;
        }
        else {
            medicationRepository.updateMedication(medicationDTO.getMedication_id(),
                    medicationDTO.getName(),
                    medicationDTO.getStart(),
                    medicationDTO.getEnd(),
                    medicationDTO.getSideEffects(),
                    medicationDTO.getDosage(),
                    medicationDTO.getId_patient());
            return true;
        }
    }

    public void create(MedicationDTO medicationDTO){
        medicationRepository.createMedication(medicationDTO.getName(),
                medicationDTO.getStart(),
                medicationDTO.getEnd(),
                medicationDTO.getSideEffects(),
                medicationDTO.getDosage(),
                medicationDTO.getId_patient());
    }

}
