package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //every window has some id, this id is called a window handle
        //based on the window handle, we can switch between windows

        String windowHandle = driver.getWindowHandle();   //get the id of the window that is currently open
        System.out.println("windowHandle = " + windowHandle);
        System.out.println(("After Switch : " + driver.getCurrentUrl()));


        Set<String> windowHandles = driver.getWindowHandles();  //get the id of "all" currently open windows "Set does not allow duplicates"
        System.out.println("windowHandles = " + windowHandles);

        //Since we now have the ID of all windows we can say switch to something that is not old window id
        for(String windowId: windowHandles){
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);   //this is the method to switch to a new window
            }
        }

        System.out.println(("After Switch : " + driver.getCurrentUrl()));



//        driver.close();

        driver.quit();
    }


    /**
     *
     * This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}

