package com.example.springdemo.repositories;

import com.example.springdemo.entities.Patient;
import com.example.springdemo.utilities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "select u from Patient u")
    List<Patient> getAll();

    @Query(value = "select u from Patient u where u.caregiver = ?1")
    List<Patient> getAllByCaregiverId(Integer caregiverId);

    @Query(value = "select u from Patient u where u.patient_id = ?1")
    Patient getPatientById(Integer patientId);

    @Transactional
    @Query(value = "delete from Patient u where u.patient_id = ?1")
    void deletePatientById(Integer patientId);

    @Transactional
    @Query(value = "insert into Patient(patient_id, id_caregiver,id_user, name, birthDate, gender, medicalRecord)" +
            "values(null, :idCaregiver,:idUser, :name, :birthDate, :gender, :medicalRecord)",
             nativeQuery = true)
    void createPatient(@Param("idCaregiver") Integer idCaregiver,
                       @Param("idUser") Integer idUser,
                       @Param("name") String name,
                       @Param("birthDate") Date birthDate,
                       @Param("gender") String gender,
                       @Param("medicalRecord") String medicalRecord);

    @Query(value = "update Patient u set u.caregiver = ?2,u.user = ?3, u.name = ?4, u.birthDate = ?5, u.gender = ?6, u.medicalRecord = ?7 where u.patient_id=?1")
    void updatePatient(Integer patientId, Integer idCaregiver,Integer idUser, String name, Date birthDate, String gender, String medicalRecord);
}
