package com.example.demo.ejercicio1;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AadvarkTest {
    @Test
    public void consumeTest(){
        log.info("Testing aadvark consume methods....");

        Aadvark aadvark = new Aadvark();

        BugEater bugEater = aadvark;
        LivingBeing livingBeing = aadvark;
        Animal animal = aadvark;

        Assert.assertEquals("Aadvark consuming bug", bugEater.consume(new Bug()));
        Assert.assertEquals("Aadvark consuming water", livingBeing.consume(new Water()));
        Assert.assertEquals("Aadvark consuming water", animal.consume(new Water()));

        Assert.assertEquals("Aadvark consuming bug", aadvark.consume(new Bug()));
        Assert.assertEquals("Aadvark consuming water", aadvark.consume(new Water()));

        Assert.assertEquals(bugEater.consume(new Bug()), aadvark.consume(new Bug()));
        Assert.assertEquals(livingBeing.consume(new Water()), aadvark.consume(new Water()));
    }
}
