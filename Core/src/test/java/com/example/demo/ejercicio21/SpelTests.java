package com.example.demo.ejercicio21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.example.demo.ejercicio21.beans.Magician;
import com.example.demo.ejercicio21.beans.MyBeanResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpelTests {
    private static ApplicationContext context;
    private static ExpressionParser spelParser = new SpelExpressionParser();
    private static StandardEvaluationContext springContext;

    @BeforeClass
    public static void beforeClass(){
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        springContext = new StandardEvaluationContext();
        MyBeanResolver resolver = context.getBean(MyBeanResolver.class);
        springContext.setBeanResolver(resolver);
    }

    @Test
    public void resolverTest(){
        log.info("Testing spel expressions with resolver...");
        Magician magician = context.getBean(Magician.class);
        springContext.setVariable("magicNumber", magician.getInitialNumber());

        Integer randomNumber = spelParser.parseExpression("@guessNumberBean.randomNumber").getValue(springContext, Integer.class);
        springContext.setVariable("randomNumber", randomNumber);

        Boolean numberGessed  = spelParser.parseExpression("#magicNumber == #randomNumber").getValue(springContext, Boolean.class);


        assertTrue(numberGessed);

    }

    @Test
    public void factoryBeanTest(){
        log.info("Testing inventors.....");

        Integer inventions = spelParser.parseExpression("@teslaBean.inventions.length").getValue(springContext, Integer.class);
        assertEquals(new Integer(3), inventions);

        List<String> inventionList = spelParser.parseExpression("@teslaBean.inventions").getValue(springContext, List.class);
        
        assertEquals(3, inventionList.size());
    }

    @Test
    public void elvisOperator(){
        log.info("testing elvis operator...");

        springContext.setVariable("name", "oga");
        assertEquals("oga", spelParser.parseExpression("#name").getValue(springContext, String.class));

        spelParser.parseExpression("#name").setValue(springContext, null);
        assertNull(spelParser.parseExpression("#name").getValue(springContext, String.class));

        assertEquals("otro oga", spelParser.parseExpression("#name?:'otro oga'").getValue(springContext, String.class));

    }

    @Test
    public void templatedExpressionTest(){
        springContext.setVariable("name", "oga");

        String greeting = spelParser.parseExpression("Aloja #{#name + ' you are'} awesome", new TemplateParserContext()).getValue(springContext, String.class);

        assertEquals("Aloja oga you are awesome", greeting);
    }
}
