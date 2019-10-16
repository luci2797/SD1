package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.utilities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
    @Query(value = "select u from Caregiver u")
    List<Caregiver> getAll();

    @Query(value = "select u from Caregiver u where u.caregiver_id = ?1")
    Caregiver getCaregiverById(Integer id);

    @Query(value = "select u from Caregiver u where u.id_doctor = ?1")
    List<Caregiver> getCaregiversByIdDoctor(Integer idDoctor);

    @Modifying
    @Query(value = "insert into Caregiver(caregiver_id, address, birth_date, gender, name, id_doctor, id_user)" +
            " values(null, :address, :birthDate, :gender, :name, :idDoctor, :idUser)",
            nativeQuery = true)
    void createCaregiver(@Param("address") String address,
                      @Param("birthDate") Date birthDate,
                      @Param("gender") Gender gender,
                      @Param("name")String name,
                      @Param("idDoctor")Integer idDoctor,
                      @Param("idUser")Integer idUser);

    @Query(value = "delete from Caregiver u where u.caregiver_id = ?1")
    void deleteCaregiverById(Integer id);

    @Query(value = "update Caregiver u SET u.address=?2, u.birthDate = ?3 , u.gender = ?4 , u.name = ?5, u.id_doctor = ?6, u.id_user = ?7 where u.caregiver_id = ?1")
    void updateCaregiver(Integer caregiverId, String address, Date birthDate, Gender gender, String name, Integer idDoctor, Integer idUser);
}
