package com.example.test.springAuth.entity.mySqlEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private Author author;
}
