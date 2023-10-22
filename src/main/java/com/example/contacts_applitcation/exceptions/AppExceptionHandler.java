package com.example.contacts_applitcation.exceptions;

import com.example.contacts_applitcation.ui.model.response.ErrorMessage;
import com.example.contacts_applitcation.ui.model.response.ErrorMessages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {UserServiceExceptions.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceExceptions exceptions, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage(new Date(),exceptions.getMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
