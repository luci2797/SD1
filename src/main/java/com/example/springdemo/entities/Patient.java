package com.example.springdemo.entities;

import com.example.springdemo.utilities.Gender;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "patient_id", unique = true, nullable = false)
    private Integer patient_id;

    @ManyToOne(targetEntity = Caregiver.class)
    @JoinColumn(name = "id_caregiver", referencedColumnName = "caregiver_id")
    private Integer id_caregiver;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "medicalRecord")
    private String medicalRecord;

    public Patient()
    {

    }

    public Patient(Integer patient_id,Integer id_caregiver, String name, Date birthDate, Gender gender, String medicalRecord)
    {
        this.patient_id = patient_id;
        this.id_caregiver = id_caregiver;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.medicalRecord = medicalRecord;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
