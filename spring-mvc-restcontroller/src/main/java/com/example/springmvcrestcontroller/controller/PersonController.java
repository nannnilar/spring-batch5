package com.example.springmvcrestcontroller.controller;

import com.example.springmvcrestcontroller.entity.Person;
import com.example.springmvcrestcontroller.service.PersonService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/creation")
    public String savePerson(){
        List.of(
                new Person("John","Doe","john@gmail.com"),
                new Person("Thomas","Hardy","thomas@gmail.com"),
                new Person("John","William","will@gmail.com")
        ).forEach(personService::savePerson);
        return "successfully";
    }

    record PersonResponse(int id, @JsonProperty("first_name") String firstName,
                                @JsonProperty("last_name") String lastName, String email){}
    private PersonResponse toPersonResponse(Person person){
        return new PersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail()
        );
    }
    @GetMapping(value = "/person/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonResponse> findAllPerson(){
        return personService.findAll().stream()
                .map(p -> toPersonResponse(p)
                ).collect(Collectors.toList());
    }
//    curl localhost:8080/person?id=2
    @GetMapping("/person")
    public PersonResponse findPersonById(@RequestParam("id") int id){
        Person person = personService.findPersonById(id);
        return toPersonResponse(person);
    }
    record PersonRequest(@JsonProperty("first_name")String firstName,
                         @JsonProperty("last_name")String lastName,String email){

    }
//    curl -X POST -H "Content-Type:application/json" -d'{"first_name":"Thaw","last_name":"Thaw","email":"thaw@gmail.com"}' "http://localhost:8080/person/all"
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/person/all",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonResponse savePerson(@RequestBody PersonRequest request){
        Person person = personService.savePerson(new Person(
                request.firstName(),
                request.lastName(),
                request.email()));
        return toPersonResponse(person);
    }
//    curl localhost:8080/person/1
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonResponse> findPersonByIdV1(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(toPersonResponse(personService.findPersonById(id)));
    }
//    curl -X PUT -H "Content-Type: application/json" -d '{"first_name":"Thomas","last_name":"Mann","email":"mann@gmail.com"}' "http://localhost:8080/person?id=2"
//    curl -X PUT -H "Content-Type: application/json" -d '{"first_name":"Thomas","last_name":"Hardy","email":"thomas@gmail.com"}' "http://localhost:8080/person?id=2"

    @PutMapping(value = "/person",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonResponse updatePerson(@RequestParam("id") int id,@RequestBody PersonRequest request){
        return toPersonResponse(personService.personUpdateImplicit(id,toPerson(request)));
    }
    private Person toPerson(PersonRequest personRequest){
        return new Person(
            personRequest.firstName(),
            personRequest.lastName(),
            personRequest.email()
        );
    }
//    curl -v -X PATCH -H "Content-Type: text/plain" -d "thomashardy@gamil.com" "http://localhost:8080/person?id=2"
    @PatchMapping(value = "/person",consumes = MediaType.TEXT_PLAIN_VALUE)
    public PersonResponse partialUpdatePerson(@RequestParam("id") int id,@RequestBody String email){
        return toPersonResponse(personService.changeEmail(id,email));
    }
//    curl -X DELETE "http://localhost:8080/person?id=2"
    @DeleteMapping("/person")
    public ResponseEntity deletePersonById(@RequestParam("id") int id){
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
