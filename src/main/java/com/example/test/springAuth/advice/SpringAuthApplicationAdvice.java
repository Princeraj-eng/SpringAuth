package com.example.test.springAuth.advice;

import com.example.test.springAuth.dto.APIResponse;
import com.example.test.springAuth.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class SpringAuthApplicationAdvice {

    private static final String FAILED = "FAILED";

    APIResponse<Map> response = new APIResponse<>();

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserNameAlreadyTakenException.class)
    public APIResponse handleUserNameAlreadyTakenException(UserNameAlreadyTakenException ex) {
        String msg = ex.getMessage();
        response.setMessage(msg);
        response.setStatus(FAILED);
        return response;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public APIResponse handleUserNotFoundException(UserNotFoundException ex) {
        String msg = ex.getMessage();
        response.setMessage(msg);
        response.setStatus(FAILED);
        return response;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RoleNotFoundException.class)
    public APIResponse handleRoleNotFoundException(RoleNotFoundException ex) {
        String msg = ex.getMessage();
        response.setMessage(msg);
        response.setStatus(FAILED);
        return response;
    }
}
