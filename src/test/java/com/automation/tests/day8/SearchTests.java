package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class SearchTests {
    private WebDriver driver;


    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            System.out.println(searchItem.getText());
            String var = searchItem.getText();
            if(!var.isEmpty()){
                System.out.println(var);
                //verifies that every search result contains "java"
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    @BeforeMethod
    public void setup(){
        //setup webDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        //close browser and destroy webDriver object
        driver.quit();
    }
}