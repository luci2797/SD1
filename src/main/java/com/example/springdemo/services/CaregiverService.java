package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.repositories.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaregiverService {
    private final CaregiverRepository caregiverRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository)
    {
        this.caregiverRepository = caregiverRepository;
    }

    public List<CaregiverDTO> getAll()
    {
        ArrayList<CaregiverDTO> caregiverDTOS = new ArrayList<CaregiverDTO>();
        for (Caregiver c: caregiverRepository.getAll()){
            caregiverDTOS.add(CaregiverBuilder.generateDTOFromCaregiver(c));
        }
        return caregiverDTOS;
    };

    public CaregiverDTO findCaregiverById(Integer id)
    {
        return CaregiverBuilder.generateDTOFromCaregiver(caregiverRepository.getCaregiverById(id));
    }

    public List<CaregiverDTO> findCaregiversByDoctor(Integer doctorId)
    {
        ArrayList<CaregiverDTO> caregiverDTOS = new ArrayList<CaregiverDTO>();
        for (Caregiver c : caregiverRepository.getCaregiversByIdDoctor(doctorId))
        {
            caregiverDTOS.add(CaregiverBuilder.generateDTOFromCaregiver(c));
        }
        return caregiverDTOS;
    }

    public void createDoctor(CaregiverDTO caregiverDTO)
    {
        caregiverRepository.createCaregiver(caregiverDTO.getAddress(),
                caregiverDTO.getBirthDate(),
                caregiverDTO.getGender(),
                caregiverDTO.getName(),
                caregiverDTO.getId_doctor(),
                caregiverDTO.getId_user());
    }

    public Boolean deleteCaregiverById(Integer id)
    {
        if (this.findCaregiverById(id) == null){
            System.out.println("Caregiver with the specified id does not exist");
            return false;
        }
        else {
            caregiverRepository.deleteCaregiverById(id);
            return true;
        }
    }

    public Boolean editCaregiver(CaregiverDTO caregiverDTO)
    {
        if (this.findCaregiverById(caregiverDTO.getCaregiver_id()) == null){
            System.out.println("Caregiver with the specified id does not exist");
            return false;
        }
        else {
            caregiverRepository.updateCaregiver(caregiverDTO.getCaregiver_id(),
                    caregiverDTO.getAddress(),
                    caregiverDTO.getBirthDate(),
                    caregiverDTO.getGender(),
                    caregiverDTO.getName(),
                    caregiverDTO.getId_doctor(),
                    caregiverDTO.getId_user());
            return true;
        }
    }

}
