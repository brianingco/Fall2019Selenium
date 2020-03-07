package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.management.modelmbean.ModelMBeanInfoSupport;
import java.util.List;

public class radioButtons {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //<input type="radio">
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));


        for(WebElement radioButton: radioButtons){

            String id = radioButton.getAttribute("id");

            //return true if button is already clicked
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + "Is selected? " +isSelected);

            //if the button is eligible to click
            //return true, if you can click on the button
            if(radioButton.isEnabled()){
                radioButton.click();
                System.out.println("Clicked on:" + radioButton.getAttribute("id"));
                Thread.sleep(1000);
            } else {
                System.out.println("Button is disabled");
            }

        }





        driver.quit();
    }
}
