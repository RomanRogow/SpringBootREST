package com.example.springcorse.FirstRestApp.repository;

import com.example.springcorse.FirstRestApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
