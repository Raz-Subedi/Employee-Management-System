package com.bway.springproject;

import com.testing.Calculation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCalc {
    static Calculation c;

    @BeforeEach
    public void init(){
        c = new Calculation();
    }

    @Test
    public void testArea(){
        int result = c.getArea(20,40);
        assertEquals(800,result,"Method Implementation Failed");
    }

    @Test
    public void testSi(){
        int si = c.getSI(5000,5,10);
        assertEquals(2500,si);
    }

    @AfterEach
    public void endMethod() {

        System.out.println("-------Method Completed-----------");
    }
}
