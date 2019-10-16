package com.example.springdemo.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "doctor_id", unique = true, nullable = false)
    private Integer doctor_id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user", referencedColumnName = "user_id")
    private Integer id_user;

    @Column(name = "firstName", length = 100)
    private String firstName;

    @Column(name = "lastName", length = 100)
    private String lastName;

    public Doctor()
    {

    }

    public Doctor(Integer doctor_id,Integer id_user, String firstName, String lastName)
    {
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
