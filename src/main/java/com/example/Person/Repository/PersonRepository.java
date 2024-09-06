package com.example.Person.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Person.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
