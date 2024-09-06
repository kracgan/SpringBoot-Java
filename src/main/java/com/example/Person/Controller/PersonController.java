package com.example.Person.Controller;
import java.util.List;
// import java.util.Locale;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.i18n.LocaleContextHolder;
// import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.Person.Entity.Person;
import com.example.Person.Repository.PersonRepository;
import com.example.Person.ResponseBean.ResponseBean;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class PersonController {
    
    @Autowired
    public PersonRepository personrepo;

    @Autowired
    public ResponseBean response;

   
    

     @GetMapping(path="/Person", produces="application/Json")
    public ResponseEntity<Object> getPersonName() {
    List<Person> PersonList = personrepo.findAll();
    response.setData(PersonList);

    return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping(path="/Person/{PersonId}", produces="application/Json")
    public ResponseEntity<Object> getPersonById(
    @PathVariable("PersonId") int PersonId) {
    Optional<Person> person = personrepo.findById(PersonId);
    
   
        response.setData(person.get());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
   
    }

    @DeleteMapping(path = "/Person/{PersonId}")
    @Operation(summary = "Deletes Person by its Id")
    
        public ResponseEntity<Object> deletePerson(@PathVariable("PersonId") int PersonId) {

            personrepo.deleteById(PersonId);

            response.setErrorCode(null);
            response.setErrorDesc(null);
            response.setData("deleted");
            return new ResponseEntity<Object>(response, HttpStatus.OK);
       
    }


}