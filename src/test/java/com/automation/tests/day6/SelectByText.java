package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //create a webElement object for the drop-down
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));

        //provide webElement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);

        //Select by visible text, option 1
        selectSimpleDropdown.selectByVisibleText("Option 2");

        //Select by visible text, option 2
        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");


        Select selectYear = new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1978");

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("May");

        Select selectDay = new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("4");

        //select all months one by one
//        List<WebElement>months = selectMonth.getOptions();
//        for(WebElement eachMonth: months){
//            String monthName = eachMonth.getText();
//            selectMonth.selectByVisibleText(monthName);
//            BrowserUtils.wait(1);
//        }

        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Florida");

        String selected = stateSelect.getFirstSelectedOption().getText();
        if(selected.equals("Florida")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }





        BrowserUtils.wait(3);
        driver.quit();
    }




}
