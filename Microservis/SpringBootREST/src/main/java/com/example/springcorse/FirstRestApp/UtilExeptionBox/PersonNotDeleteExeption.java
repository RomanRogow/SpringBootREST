package com.example.springcorse.FirstRestApp.UtilExeptionBox;

public class PersonNotDeleteExeption extends RuntimeException{
    public PersonNotDeleteExeption(String msg) {
        super(msg);
    }
}
