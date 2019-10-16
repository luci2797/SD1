package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.entities.Caregiver;

public class CaregiverBuilder {

    public static CaregiverDTO generateDTOFromCaregiver(Caregiver caregiver){
        return new CaregiverDTO(caregiver.getCaregiver_id(),
                caregiver.getId_user(),
                caregiver.getId_doctor(),
                caregiver.getName(),
                caregiver.getBirthDate(),
                caregiver.getGender(),
                caregiver.getAddress());
    }

    public static Caregiver generateCaregiverFromDTO(CaregiverDTO caregiverDTO){
        return new Caregiver(caregiverDTO.getCaregiver_id(),
                caregiverDTO.getId_user(),
                caregiverDTO.getId_doctor(),
                caregiverDTO.getName(),
                caregiverDTO.getBirthDate(),
                caregiverDTO.getGender(),
                caregiverDTO.getAddress());
    }
}
