package com.example.test.springAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private String password;
    private String phoneNumber;

//    public String getUsername() {
//        return username;
//    }

//    public Set<String> getRoleNames() {
//        return roleNames;
//    }

    private Set<String> roleNames;
}
