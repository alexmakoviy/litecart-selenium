package net.litecart.demo;


import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class FirstTest extends TestBase{

    @Test
    public void testAppearance(){
        clickElement(By.cssSelector("[id=app-appearance]"));
        checkIfDisplayed(By.xpath("//h1[contains(text(),'Template')]"));

        clickElement(By.cssSelector("[id=doc-template]"));
        checkIfDisplayed(By.xpath("//h1[contains(text(),'Template')]"));

        clickElement(By.cssSelector("[id=doc-logotype]"));
        checkIfDisplayed(By.xpath("//h1[contains(text(),' Logotype')]"));
    }

    @Test
    public void testCatalog(){
        driver.findElement(By.cssSelector("[id=app-catalog")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),'Catalog')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-catalog]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),'Catalog')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-product_groups]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Product Groups')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-option_groups]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Option Groups')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-manufacturers]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),'Manufacturers')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-suppliers]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Suppliers')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-delivery_statuses]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Delivery Statuses')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-sold_out_statuses]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Sold Out Statuses')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-quantity_units]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' Quantity Units')]")).isDisplayed());

        driver.findElement(By.cssSelector("[id=doc-csv]")).click();
        assertEquals(true, driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]")).isDisplayed());
    }
}

