package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTestNGTest {


    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("Before Class");
    }

    @BeforeMethod
    //runs before every test
    public void setup(){
        System.out.println("before every test");
    }

    @AfterMethod
    //runs automatically after every test
    public void tearDown (){
        System.out.println("after method");
    }


    @Test
    public void test1(){
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void test2(){
        int num1 = 11;
        int num2 = 10;
        //Also known as - hard assertion
        //if assertion fails - it stops the execution (due to exception)
        Assert.assertTrue(num1 > num2);
    }






}
