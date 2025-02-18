package com.example.test.springAuth.controller;

import com.example.test.springAuth.dto.APIResponse;
import com.example.test.springAuth.dto.UserDTO;
import com.example.test.springAuth.entity.pSqlEntity.User_app;
import com.example.test.springAuth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final String SUCCESS = "SUCCESS";

    @Autowired
    private IUserService userService;

    // Create User and Assign Roles
    @PostMapping
    public ResponseEntity<APIResponse> createUser(@RequestBody UserDTO userDTO) {
        User_app user = userService.createUser(userDTO);

        APIResponse<User_app> responseDTO = APIResponse.<User_app>builder()
                .message("User details")
                .status(SUCCESS)
                .result(user)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // Get User by ID
    @GetMapping("/{userName}")
    public ResponseEntity<APIResponse> getUser(@PathVariable String userName) {
        User_app user = userService.getUserById(userName);
        APIResponse<User_app> responseDTO = APIResponse.<User_app>builder()
                .message("User details")
                .status(SUCCESS)
                .result(user)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<APIResponse> getUser() {
       List<User_app> user = userService.getAllUser();
        APIResponse<List<User_app>> responseDTO = APIResponse.<List<User_app>>builder()
                .message("All User details")
                .status(SUCCESS)
                .result(user)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
