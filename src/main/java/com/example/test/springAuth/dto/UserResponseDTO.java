package com.example.test.springAuth.dto;

import com.example.test.springAuth.entity.User_app;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;

    private String email;
    
    private String phoneNumber;

    private String username;

    private String firstName;

    private String lastName;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private String password;
    private Set<String> roles;

    public UserResponseDTO(User_app user) {
    }
}
