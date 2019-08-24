package net.litecart.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TestBase {
    static WebDriver driver;
    static String baseUrl = "http://demo.litecart.net/admin/";

    @BeforeClass
    public static void startBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("[type=submit]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#notices")));
    }

    @AfterClass
    public static void stopBrowser(){
        driver.quit();
    }

    @Before
    public void openLink(){
        driver.get(baseUrl);
    }

    boolean isElementPresent(WebDriver driver, By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void checkIfDisplayed(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       // assertEquals(true, driver.findElement(locator).isDisplayed());
    }

    public void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }
}
