package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");


        //verify that the 1st box is not selected and the second is selected
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(2);

        //lets click on teh first checkbox and verify its clicked
        WebElement checkbox1 = checkBoxes.get(0);
        checkbox1.click();

        //you can do the above actions in one step:
        //checkBoxes.get(0).click

        BrowserUtils.wait(2);
        if(checkbox1.isSelected()){
            System.out.println("Test Passed");
            System.out.println("Checkbox #1 is selected");
        } else {
            System.out.println("Test Failed");
            System.out.println("Checkbox #1 is not selected");
        }


        driver.quit();
    }
}
