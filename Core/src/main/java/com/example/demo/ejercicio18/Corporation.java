package com.example.demo.ejercicio18;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
@Named("Capsule")
public class Corporation {
    
    @Inject
    @Qualifier("generalDirectorBean")
    private IDirector generalDirector;

    @Inject
    private IDirector itDirector;

    @Inject
    @Qualifier("generalSecreatryBean")
    private Optional<Secretary> generalSecretary;

    @Inject
    @SecretaryAssistantQualifier
    private Secretary secretaryAssistant;

    @Inject
    private Manager manager;
}
