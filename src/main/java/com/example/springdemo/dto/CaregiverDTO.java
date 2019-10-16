package com.example.springdemo.dto;

import com.example.springdemo.entities.Doctor;
import com.example.springdemo.entities.User;
import com.example.springdemo.utilities.Gender;

import java.util.Date;

public class CaregiverDTO {

    private Integer caregiver_id;
    private Integer id_user;
    private Integer id_doctor;
    private String name;
    private Date birthDate;
    private Gender gender;
    private String address;

    public CaregiverDTO(Integer caregiver_id, Integer id_user, Integer id_doctor, String name, Date birthDate, Gender gender, String address) {
        this.caregiver_id = caregiver_id;
        this.id_user = id_user;
        this.id_doctor = id_doctor;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public Integer getCaregiver_id() {
        return caregiver_id;
    }

    public void setCaregiver_id(Integer caregiver_id) {
        this.caregiver_id = caregiver_id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Integer id_doctor) {
        this.id_doctor = id_doctor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
