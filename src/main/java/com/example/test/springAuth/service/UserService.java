package com.example.test.springAuth.service;

import com.example.test.springAuth.dto.UserDTO;
import com.example.test.springAuth.entity.Roles;
import com.example.test.springAuth.entity.User_app;
import com.example.test.springAuth.exception.*;
import com.example.test.springAuth.repository.RoleRepository;
import com.example.test.springAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Create a new user and assign roles
    @Transactional
    public User_app createUser(UserDTO userDTO) {


        // Check if the username already exists
        Optional<User_app> existingUser = userRepository.findByUsername(userDTO.getUsername());

        if (existingUser.isPresent()) {
            // Username already exists, throw an exception or handle accordingly
            throw new UserNameAlreadyTakenException("username: "+userDTO.getUsername() +" is already taken");

        }
        User_app user = new User_app();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setCreatedOn(new Date());
        user.setCreatedBy(userDTO.getUsername());
        user.setUpdatedBy(userDTO.getUsername());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUpdatedOn(new Date());
        Set<Roles> roles = userDTO.getRoleNames().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RoleNotFoundException("Role not found :- " + roleName)))
                .collect(Collectors.toSet());

        user.setRoles(roles);
        return userRepository.save(user);
    }

    // Get user by ID
    public User_app getUserById(String userName) {
        return userRepository.findByUsername(userName)
                .map(user -> {
                    user.setRoles(new HashSet<>());
//                    user.getRoles().stream().map(Roles::getName).collect(Collectors.toSet());
                    System.out.println(user.getRoles()+"    .............");
                    return user;
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with User Name : " + userName));
    }

//    user.ifPresent(u -> u.getRoles().size()); // Force roles to initialize
//    return user;


    public List<User_app> getAllUser() {
        return userRepository.findAll();
    }
}
