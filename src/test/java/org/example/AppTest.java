package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
     public void testPow(){

        double base = 2;
        int exponent = 3;
        double expected = 8.0;

        double check = App.pow(base, exponent);
        assertEquals(expected, check, 0.001);
    }

    public void testMortgageCalc(){
        double total = 1000;
        double interest = 5;
        int years = 3;
        double expected = 29.97;

        double check = App.mortgageCalc(total, interest, years);
        assertEquals(expected, check, 0.001);
    }

    public void testRound(){
        double num = 10.9432;
        double expected = 10.94;

        double check = App.round(num);
        assertEquals(expected, check, 0.001);
    }
}
