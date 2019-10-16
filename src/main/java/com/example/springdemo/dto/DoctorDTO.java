package com.example.springdemo.dto;

import com.example.springdemo.entities.User;

public class DoctorDTO {
    private Integer doctor_id;
    private Integer id_user;
    private String firstName;
    private String lastName;

    public DoctorDTO(Integer doctor_id, Integer id_user, String firstName, String lastName) {
        this.doctor_id = doctor_id;
        this.id_user = id_user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
