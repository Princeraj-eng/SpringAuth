package com.example.test.springAuth.util;

import com.example.test.springAuth.entity.pSqlEntity.Roles;
import com.example.test.springAuth.repository.pSqlRepo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        long count = roleRepository.count();
        if (count == 0) {
            roleRepository.save(new Roles("ROLE_ADMIN"));
            roleRepository.save(new Roles("ROLE_USER"));
        }
    }
}
