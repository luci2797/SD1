package com.example.springdemo.dto;

import com.example.springdemo.entities.Patient;

import java.util.Date;

public class MedicationDTO {
    private Integer medication_id;
    private String name;
    private Date start;
    private Date end;
    private String sideEffects;
    private Integer dosage;
    private Integer id_patient;

    public MedicationDTO(Integer medication_id, String name, Date start, Date end, String sideEffects, Integer dosage, Integer id_patient) {
        this.medication_id = medication_id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.sideEffects = sideEffects;
        this.dosage = dosage;
        this.id_patient = id_patient;
    }

    public Integer getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Integer medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }
}
