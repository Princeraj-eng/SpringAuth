package com.example.test.springAuth.repository.pSqlRepo;

import com.example.test.springAuth.entity.pSqlEntity.User_app;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User_app, Long> {

    Optional<User_app> findByUsername(String username);
}
