package com.example.demo.ejercicio20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ejercicio20/beans.xml"})
public class PlaceHoldersTests {
    
    @Autowired
    private FavouriteRockBands rockBands;

    @Value("${service.name}")
    private String serviceName;

    @Value("${service.description}")
    private String serviceDescription;

    @Test
    public void testRockBand(){
        log.info("Testing for {}", rockBands.getDescritption());

        assertEquals("Bon jovi", rockBands.getFirstRockBand());
        assertEquals("My awesome description", serviceDescription);
    }

    @SneakyThrows
    @Test
    public void txtFile(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext();

        log.info("Loading file system resources");

        Resource resource = applicationContext.getResource("src/main/resources/spring/ejercicio20/certificatic-resources/my-textfile.txt");

        ResourceLoaderUtils.loadTextResourceTest(resource);
        ((AbstractApplicationContext)applicationContext).close();
    }
    
}
