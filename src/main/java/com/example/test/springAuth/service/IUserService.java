package com.example.test.springAuth.service;

import com.example.test.springAuth.dto.UserDTO;
import com.example.test.springAuth.entity.pSqlEntity.User_app;

import java.util.List;

public interface IUserService {

    public User_app createUser(UserDTO userDTO);

    public User_app getUserById(String userName);

    public List<User_app> getAllUser();
}
