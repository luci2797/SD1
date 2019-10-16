package com.example.springdemo.repositories;

import com.example.springdemo.entities.Patient;
import com.example.springdemo.utilities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "select u from Patient u")
    List<Patient> getAll();

    @Query(value = "select u from Patient u where u.id_caregiver = ?1")
    List<Patient> getAllByCaregiverId(Integer caregiverId);

    @Query(value = "select u from Patient u where u.patient_id = ?1")
    Patient getPatientById(Integer patientId);

    @Query(value = "delete from Patient u where u.patient_id = ?1")
    void deletePatientById(Integer patientId);

    @Query(value = "insert into Patient(patient_id, id_caregiver, name, birthDate, gender, medicalRecord)" +
            "values(null, :patientId, :idCaregiver, :name, :birthDate, :gender, :medicalRecord)",
             nativeQuery = true)
    void createPatient(@Param("idCaregiver") Integer idCaregiver,
                       @Param("name") String name,
                       @Param("birthDate") Date birthDate,
                       @Param("gender") Gender gender,
                       @Param("medicalRecord") String medicalRecord);

    @Query(value = "update Patient u set u.id_caregiver = ?2, u.name = ?3, u.birthDate = ?4, u.gender = ?5, u.medicalRecord = ?6 where u.patient_id=?1")
    void updatePatient(Integer patientId, Integer idCaregiver, String name, Date birthDate, Gender gender, String medicalRecord);
}
