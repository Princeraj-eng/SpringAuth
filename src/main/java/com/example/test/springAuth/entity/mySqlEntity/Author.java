package com.example.test.springAuth.entity.mySqlEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String authorName;

    @OneToMany
    @JoinColumn(name = "bookId",referencedColumnName = "id")
    private List<Book> book;
}
