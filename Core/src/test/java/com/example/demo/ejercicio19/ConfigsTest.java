package com.example.demo.ejercicio19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ConfigsTest {
    
    @Autowired
    private ApplicationContext context;

    @Inject
    //@Qualifier("quadraticEquationService")
    private IQuadraticEquationService quadraticEquationService;

    @Inject
    @Qualifier("quadraticEquationServiceBean")
    private IQuadraticEquationService quadraticEquationService2;

    @Inject
    QuadraticEquation quadraticEquation;

    @Resource(name = "dummyService")
    DummyService dummyService;

    @Resource
    DummyRepository dummyRepository;

    @Test
    public void injectResourceTest(){
        log.info("Esting injection methods and configs");

        assertNotNull(dummyRepository);
        assertNotNull(dummyService);
        assertNotNull(quadraticEquation);
        assertNotNull(quadraticEquationService2);
        assertNotNull(quadraticEquationService);
        assertNotNull(context);

        String result = quadraticEquationService.quadraticEquationToString(1, 2, 3);

        log.info(result);

        assertNotNull(result);
        assertEquals("1.0x^2 + 2.0 +  = 0", result);
    }

}
