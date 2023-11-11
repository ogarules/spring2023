package com.example.demo.ejercicio30.parte1;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.ejercicio29.models.Person;

@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "person.age.required", "Age is required");

        Person person = (Person)target;

        if(person.getAge() != null && person.getAge() < 18){
            errors.rejectValue("age", "person.age.gt18.required" , new Object[] {18}, "Age must be grater or equal than N.");
        }

        if(person.getName() == null || person.getName().trim().isEmpty()){
            errors.rejectValue("name", "", "Name is required");
        }
    }
    
}
