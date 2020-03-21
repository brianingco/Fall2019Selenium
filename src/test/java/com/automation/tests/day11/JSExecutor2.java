package com.automation.tests.day11;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";

        //we create a javaScriptExecutor object by casting webDriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title is javaScript code
        //document - represents HTML page
        String actual = (String) js.executeScript("return document.title");

        //or use toString instead of casting:
        //String actual = js.executeScript("return document.title").toString;
        Assert.assertEquals(actual, expected);
    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
