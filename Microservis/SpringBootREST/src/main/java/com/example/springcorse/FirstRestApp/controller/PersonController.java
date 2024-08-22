package com.example.springcorse.FirstRestApp.controller;

import com.example.springcorse.FirstRestApp.UtilExeptionBox.PersonNotCreatedExeption;
import com.example.springcorse.FirstRestApp.UtilExeptionBox.PersonNotDeleteExeption;
import com.example.springcorse.FirstRestApp.model.Person;
import com.example.springcorse.FirstRestApp.service.PersonsService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {


    private final PersonsService personsService;

    @Autowired
    public PersonController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personsService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id")int id) {

        return personsService.findOne(id);
    }
    @PostMapping()
    public ResponseEntity<HttpStatus> createPerson(@RequestBody @Valid Person person
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();

            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                errors.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";  ");
            }
            throw new PersonNotCreatedExeption(errors.toString());
        }
        personsService.savePersons(person);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping
    public Person updatePersons (@RequestBody Person person){
        personsService.savePersons(person);
        return person;
    }
    @DeleteMapping("/{id}")
    public String deletePerson (@PathVariable int id){
        Person person = personsService.findOne(id);

        if(person == null){
            throw new PersonNotDeleteExeption("В базе данных нет сотрудника с ID " + id);
        }

        personsService.deletePerson(id);
        return "Сотрудник с ID: " + id + " был удален!";
    }
}
