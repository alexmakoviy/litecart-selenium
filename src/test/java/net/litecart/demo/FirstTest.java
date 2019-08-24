package net.litecart.demo;

import org.junit.Test;
import org.openqa.selenium.By;

public class FirstTest extends TestBase{

    @Test
    public void testAppearance() throws InterruptedException {
        driver.findElement(By.cssSelector("[id=app-appearance]")).click();
        isElementPresent(driver, By.cssSelector("h1"));
    }
}

