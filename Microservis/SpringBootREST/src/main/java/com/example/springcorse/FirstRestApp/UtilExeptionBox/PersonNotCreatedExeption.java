package com.example.springcorse.FirstRestApp.UtilExeptionBox;

public class PersonNotCreatedExeption extends RuntimeException {
    public PersonNotCreatedExeption(String msg) {
        super(msg);
    }
}
