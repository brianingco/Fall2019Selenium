package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.SourceVersion;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {
        //to start selenium script we need:
        //setup webDriver (browser driver) and create webDriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //in selenium, everything starts from WebDriver interface
        //ChromeDriver extends RemoteWebDriver  --> implements WebDriver

        driver.get("http://google.com");  //to open a website

        Thread.sleep(3000);   //for demo to wait 3 seconds
        String title = driver.getTitle();  //returns <title> Some title<t/title>
        System.out.println("Title = " + title);


        driver.close();  //to close browser

    }
}
