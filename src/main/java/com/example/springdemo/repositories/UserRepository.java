package com.example.springdemo.repositories;

import com.example.springdemo.entities.User;
import com.example.springdemo.utilities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u")
    List<User> getAll();

    @Query(value = "SELECT u FROM User u WHERE u.user_id = ?1")
    User getUserByUser_id(Integer userId);

    @Query(value = "SELECT u from User u where u.username = ?1")
    List<User> getUsersByUsername(String username);

    @Modifying
    @Query(value = "insert into User (id, password, role, username) values(null, :password, :role, :username)",
    nativeQuery = true)
    void createUser(@Param("username") String username,@Param("password") String password,@Param("role") Role role);

    @Query(value = "delete from User u where u.user_id = ?1")
    void deleteUserById(Integer id);
}
