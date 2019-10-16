package com.example.springdemo.services;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.builders.UserBuilder;
import com.example.springdemo.entities.User;
import com.example.springdemo.repositories.UserRepository;
import com.example.springdemo.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll()
    {
        ArrayList<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (User u : userRepository.getAll()){
            userDTOS.add(UserBuilder.generateDTOFromUser(u));
        }
        return userDTOS;
    }

    public UserDTO getUserById(Integer id)
    {
        return UserBuilder.generateDTOFromUser(userRepository.getUserByUser_id(id));
    }

    public UserDTO getUserByUsername(String username)
    {
        return UserBuilder.generateDTOFromUser(userRepository.getUsersByUsername(username).get(0));
    }

    public Boolean login(String username, String password)
    {
        UserDTO userDTO = this.getUserByUsername(username);
        if (userDTO == null){
            return false;
        }
        else {
            if (userDTO.getPassword().equals(password)){
                return true;
            }
            else return false;
        }
    }

    public Boolean register(String username, String password, Role role)
    {
        if (this.getUserByUsername(username) == null){
            userRepository.createUser(username, password, role);
            return true;
        }
        else {
            System.out.println("user already exists");
            return false;
        }
    }

}
