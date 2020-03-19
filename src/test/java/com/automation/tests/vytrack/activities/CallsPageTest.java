package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CallsPageTest {
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;
    private String storeManagerUserName="storemanager85";
    private String storeManagerPassword="UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy =By.cssSelector("#user-menu > a");
    private By currentOwnerBy = By.id("s2id_oro_calendar_event_form_calendar");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(5);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }


    @Test(description = "default options")
    public void verifyDefaultValues() throws InterruptedException {
    Thread.sleep(4000);

    //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText();
        String defaultOwnerName = driver.findElement(currentOwnerBy).getText();
        Assert.assertEquals(currentUserName,defaultOwnerName);
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
