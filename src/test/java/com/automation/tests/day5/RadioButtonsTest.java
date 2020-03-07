package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class RadioButtonsTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //<input type="radio" id="black" name="color"     (id is always unique and best to use)
        WebElement blackButton = driver.findElement(By.id("black"));

        //if its visible and eligible to click
        if(blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("Clicked on black button");
            blackButton.click();
        }else {
            System.out.println("Failed to click on black button");
        }
        Thread.sleep(2000);


        //how do we verify the button was clicked?
        if(blackButton.isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }










        driver.quit();
    }
}
