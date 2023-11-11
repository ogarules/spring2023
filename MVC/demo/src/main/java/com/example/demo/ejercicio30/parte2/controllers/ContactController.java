package com.example.demo.ejercicio30.parte2.controllers;

import javax.validation.Valid;

import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.ejercicio30.parte2.customValidators.ContactFormValidator;
import com.example.demo.ejercicio30.parte2.models.Contact;

import java.util.List;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/contact")
@SessionAttributes({"contactForm", "confirmationId"})
public class ContactController {
    
    @Autowired
    private ContactFormValidator validator;

    @InitBinder(value = "contactForm")
    private void configInitBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getContactForm(Model model){
        log.info("Loading contact form");

        Contact contactForm = new Contact();

        contactForm.setHiddenMessage("contact-form-1");
        model.addAttribute("contactForm", contactForm);

        return "contactForm/contact_form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @Valid @ModelAttribute("contactForm") Contact contactForm, BindingResult result){
        log.info("Submitting contact form");

        if(result.hasErrors()){
            return "contactForm/contact_form";
        }

        String confirmationId = "1";

        model.addAttribute("confirmationId", confirmationId);
        model.addAttribute("contactForm", contactForm);

        log.info("Submit completed id => {}", confirmationId);

        return "redirect:/contact/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    private String successProcessed(@ModelAttribute("contactForm") Contact contactForm){
        log.info("Succes!!!!");

        return "contactForm/show_data";
    }

    @ModelAttribute("availableCourses")
    public List<String> availableCourses(){
        List<String> courses = new ArrayList<>();

        courses.add("Java");
        courses.add("C#");
        courses.add("Python");
        courses.add("NodeJS");
        courses.add("Angular");
        courses.add("PHP");

        return courses;
    }

    @ModelAttribute("availableTutours")
    public List<String> availableTutours(){
        List<String> courses = new ArrayList<>();

        courses.add("MR OGA");
        courses.add("MR Bruce Wayne");
        courses.add("MR Kent");

        return courses;
    }

    @ModelAttribute("genders")
    public List<String> genders(){
        List<String> courses = new ArrayList<>();

        courses.add("Female");
        courses.add("Male");

        return courses;
    }
}
