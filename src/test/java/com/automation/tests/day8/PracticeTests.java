package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        //setup webDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);

        driver.manage().window().maximize();
        BrowserUtils.wait(5);


    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(5);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        BrowserUtils.wait(5);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(5);


        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(expected, actual,"Sub-header message is not matching!");
    }
    }


    //Interview Questions:
    //How do you handle SSL issues in Selenium?
    //ChromeOptions - use to customize browser for tests.
    //ChromeOptions chromeOptions = new Chrome Options();
