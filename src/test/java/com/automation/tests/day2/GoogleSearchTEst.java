package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTEst {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);

        //By.name("q")  --> [name="q"]    (Name is one of the Selenium locators, there are 8. We use them to find elements
        //to choose locator, just use By.locator
        WebElement search = driver.findElement(By.name("q"));

        //Once we find an element, how do you enter text?
        //To enter text, use sendKeys() method

        //Hot to press Enter after entering the text?
        //use Key.ENTER (to perform a keyboard click)
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        driver.quit();







    }


}
