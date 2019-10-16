package com.example.springdemo.entities;

import com.example.springdemo.utilities.Gender;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "caregiver")
public class Caregiver {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "caregiver_id", unique = true, nullable = false)
    private Integer caregiver_id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user", referencedColumnName = "user_id")
    private Integer id_user;

    @ManyToOne(targetEntity = Doctor.class)
    @JoinColumn(name = "id_doctor", referencedColumnName = "doctor_id")
    private Integer id_doctor;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "address", length = 200)
    private String address;

    public Caregiver(){

    }

    public Caregiver(Integer caregiver_id,Integer id_user, Integer id_doctor, String name, Date birthDate, Gender gender, String address) {
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
