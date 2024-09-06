package com.example.Person.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Schema(name = "Person", description = "This is model class of Person, it contains property and getter-setter methods")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PersonId;
    
    private String PersonName;
    private String PersonEmail;

    
    public Person(int personId, String personName, String personEmail) {
        PersonId = personId;
        PersonName = personName;
        PersonEmail = personEmail;
    }

    public Person() {
    }
       

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }


    public String getPersonEmail() {
        return PersonEmail;
    }

    public void setPersonEmail(String personEmail) {
        PersonEmail = personEmail;
    }

     

}