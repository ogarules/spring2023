package com.example.demo.ejercicio31;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicio29.models.Person;

@RestController
@RequestMapping("rest/persons")
public class PersonRestController {
    
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());


    @PostConstruct
    private void init(){
        for(int i=0; i <3;i++){
            Person p = new Person();
            p.setId(i + 1);
            p.setName("OGA " + (i+1));
            p.setAge(100+i + 1);
            persons.add(p);
        }
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return persons;
    }

    @PostMapping
    public Person creatPerson(@RequestBody Person person){

        person.setId(persons.size() + 1);
        persons.add(person);

        return person;

    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id){
        return persons.stream().filter(r -> id.equals(r.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("No existe esta personita"));
    }



}
