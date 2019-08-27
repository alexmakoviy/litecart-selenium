package net.litecart.demo;


import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class AdminPageTest extends TestBase{

    @Test
    public void testAppearance(){
        driver.findElement(By.cssSelector("#app-appearance")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Template')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-template")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Template')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-logotype")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Logotype')]")).isDisplayed());
    }

    @Test
    public void testCatalog(){
        driver.findElement(By.cssSelector("#app-catalog")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Catalog')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-catalog")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Catalog')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-product_groups")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Product Groups')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-option_groups")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Option Groups')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-manufacturers")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Manufacturers')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-suppliers")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Suppliers')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Delivery Statuses')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-sold_out_statuses")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Sold Out Statuses')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-quantity_units")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Quantity Units')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]")).isDisplayed());
    }

    @Test
    public void testCountries(){
        driver.findElement(By.cssSelector("#app-countries")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Countries')]")).isDisplayed());
    }

    @Test
    public void testCurrencies(){
        driver.findElement(By.cssSelector("#app-currencies")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Currencies')]")).isDisplayed());
    }

    @Test
    public void testCustomers(){
        driver.findElement(By.cssSelector("#app-customers")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Customers')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-customers")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Customers')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-newsletter")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Newsletter')]")).isDisplayed());
    }

    @Test
    public void testGeoZones(){
        driver.findElement(By.cssSelector("#app-geo_zones")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Geo Zones')]")).isDisplayed());
    }

    @Test
    public void testLanguages(){
        driver.findElement(By.cssSelector("#app-languages")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Languages')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-languages")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Languages')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-storage_encoding")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Storage Encoding')]")).isDisplayed());
    }

    @Test
    public void testModules(){
        driver.findElement(By.cssSelector("#app-modules")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Customer Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-customer")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Customer Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-shipping")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Shipping Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-payment")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Payment Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-order")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Order Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-order_total")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Order Total Modules')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-jobs")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Job Modules')]")).isDisplayed());
    }

    @Test
    public void testOrders(){
        driver.findElement(By.cssSelector("#app-orders")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Orders')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-orders")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Orders')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-order_statuses")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Order Statuses')]")).isDisplayed());
    }

    @Test
    public void testPages(){
        driver.findElement(By.cssSelector("#app-pages")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Pages')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-pages")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Pages')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]")).isDisplayed());
    }

    @Test
    public void testReports(){
        driver.findElement(By.cssSelector("#app-reports")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Monthly Sales')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-monthly_sales")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Monthly Sales')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-most_sold_products")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Most Sold Products')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-most_shopping_customers")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Most Shopping Customers')]")).isDisplayed());
    }

    @Test
    public void testSettings(){
        driver.findElement(By.cssSelector("#app-settings")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-store_info")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-email")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-listings")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-images")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-checkout")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-advanced")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-security")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Settings')]")).isDisplayed());

    }

    @Test
    public void testSlides(){
        driver.findElement(By.cssSelector("#app-slides")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Slides')]")).isDisplayed());
    }

    @Test
    public void testTax(){
        driver.findElement(By.cssSelector("#app-tax")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Tax Rates')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-tax_rates")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Tax Rates')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-tax_classes")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Tax Classes')]")).isDisplayed());
    }

    @Test
    public void testTranslation(){
        driver.findElement(By.cssSelector("#app-translations")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Search Translations')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-search")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Search Translations')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-scan")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Scan Files For Translations')]")).isDisplayed());

        driver.findElement(By.cssSelector("#doc-csv")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]")).isDisplayed());
    }

    @Test
    public void testUsers(){
        driver.findElement(By.cssSelector("#app-users")).click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(),' Users')]")).isDisplayed());
    }

    @Test
    public void testVQmods(){
        driver.findElement(By.cssSelector("#app-vqmods")).click();
        assertTrue(driver.findElements(By.xpath("//h1[contains(text(),' vQmods')]")).size() < 1);
    }






}

