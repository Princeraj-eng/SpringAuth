package com.example.test.springAuth.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    public Roles(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
//    @JsonBackReference
     Set<User_app> users ;

}
