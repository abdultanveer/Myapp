package com.next.myapp;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Calendar;

public class CalculatorTest extends TestCase {

    @Test
    public static void test_addmethod(){
        int expectedresult = 40;
        int actualresult = Calculator.add(10,20);
        assertEquals(expectedresult,actualresult);
    }

    @Test
    public static void test_subtractmethod(){
        int expected = 40;
        int actual = Calculator.subtract(50,10);
        assertEquals(expected,actual);
    }

}