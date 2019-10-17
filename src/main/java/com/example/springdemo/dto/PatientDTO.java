package com.example.springdemo.dto;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.utilities.Gender;

import java.util.Date;

public class PatientDTO {
    private Integer patient_id;
    private Integer id_caregiver;
    private Integer id_user;
    private String name;
    private Date birthDate;
    private String gender;
    private String medicalRecord;

    public PatientDTO(Integer patient_id, Integer id_caregiver,Integer id_user, String name, Date birthDate, String gender, String medicalRecord) {
        this.patient_id = patient_id;
        this.id_caregiver = id_caregiver;
        this.id_user = id_user;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.medicalRecord = medicalRecord;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getId_caregiver() {
        return id_caregiver;
    }

    public void setId_caregiver(Integer id_caregiver) {
        this.id_caregiver = id_caregiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
