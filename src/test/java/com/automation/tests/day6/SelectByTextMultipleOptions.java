package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {



        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

       //Whether this select element supports multiple options
        Select languageSelect = new Select(driver.findElement(By.name("languages")));
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);

        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("Python");
        languageSelect.selectByVisibleText("Ruby");

        //lets get all selected options
        List<WebElement>selectedLanguages = languageSelect.getAllSelectedOptions();
        for(WebElement selectedLanguage: selectedLanguages)
        System.out.println(selectedLanguage.getText());


        BrowserUtils.wait(3);
        driver.quit();
    }
}
