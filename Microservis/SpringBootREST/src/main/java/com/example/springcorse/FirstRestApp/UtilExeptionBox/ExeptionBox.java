package com.example.springcorse.FirstRestApp.UtilExeptionBox;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionBox {
    @ExceptionHandler
    private ResponseEntity<PersonsErrorResponse> handleException(PersonNotFountExeption e) {
        PersonsErrorResponse response = new PersonsErrorResponse(
                "Сотрудник с таким ID не найден",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<PersonsErrorResponse> handkeExeption(PersonNotCreatedExeption e) {
        PersonsErrorResponse response = new PersonsErrorResponse(
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<PersonsErrorResponse> handkeExeption(Exception e) {
        PersonsErrorResponse response = new PersonsErrorResponse(
                "Не корректный ввод",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
