package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoSelectDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click(); //to expand the options
        Thread.sleep(5000);

        driver.findElement(By.linkText("Amazon")).click(); //click on the option











        BrowserUtils.wait(5);
        driver.quit();


    }

}
