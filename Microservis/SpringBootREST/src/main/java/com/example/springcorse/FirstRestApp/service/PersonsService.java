package com.example.springcorse.FirstRestApp.service;

import com.example.springcorse.FirstRestApp.model.Person;
import com.example.springcorse.FirstRestApp.repository.PersonRepository;
import com.example.springcorse.FirstRestApp.UtilExeptionBox.PersonNotFountExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class PersonsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFountExeption::new);
    }
    @Transactional
    public void savePersons(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

}
