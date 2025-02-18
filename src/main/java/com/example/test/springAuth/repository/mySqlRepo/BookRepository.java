package com.example.test.springAuth.repository.mySqlRepo;

import com.example.test.springAuth.entity.mySqlEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
