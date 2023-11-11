package com.example.demo.ejercicio29.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.ejercicio29.models.Person;
import com.example.demo.ejercicio30.parte1.PersonValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/person")
@SessionAttributes({"personCreated", "servertime"})
public class PersonController {
    
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    PersonValidator validator;



    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String showPersonsPage(@ModelAttribute("personForm") Person personForm, Model model){
        log.info("Showing persons page");

        model.addAttribute("persons", persons);

        personForm.setAge(200);
        personForm.setName("Capturar....");

        model.addAttribute("personForm", personForm);

        return "person/list_and_create_person";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(Model model, @ModelAttribute Person personForm,
    BindingResult result){
        log.info("Creating new person ...");

        validator.validate(personForm, result);

        if(result.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.personForm", result);
            model.addAttribute("personForm", personForm);

            model.addAttribute("servertime", new Date());

            return "person/list_and_create_person";
        }

        persons.add(personForm);

        model.addAttribute("personCreated", personForm);
        model.addAttribute("servertime", new Date());

        return "redirect:/person/showdata";
    }

    @RequestMapping(value = "/showdata", method = {RequestMethod.GET, RequestMethod.POST})
    public String showPerson(Model model, @ModelAttribute("personCreated") Person personCreated
                                        , @ModelAttribute("servertime") Date servertime){
        log.info("Showing data...");

        model.addAttribute("personCreated", personCreated);
        model.addAttribute("servertime", servertime);

        return "person/show_person_data";
    }
}
