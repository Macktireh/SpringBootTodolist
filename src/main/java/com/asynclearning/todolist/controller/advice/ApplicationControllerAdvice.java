package com.asynclearning.todolist.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.asynclearning.todolist.DTO.ErrorDTO;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ EntityNotFoundException.class })
    public @ResponseBody ErrorDTO handleNotFoundException(EntityNotFoundException exception) {
        return new ErrorDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ EntityExistsException.class })
    public @ResponseBody ErrorDTO handleConflictException(EntityExistsException exception) {
        return new ErrorDTO(HttpStatus.CONFLICT.value(), exception.getMessage());
    }

}
