package net.litecart.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeTask3 {
    EventFiringWebDriver driver;
    static String url = "http://demo.litecart.net///";

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.register(new EventListener());

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        driver.get(url);
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void testAddRemoveFromCart(){
        addPopularToCart();
        goToCart();
        deleteFromCart();
    }

    private void addPopularToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 4);

        List<WebElement> products = getProducts();
        int productsCount = products.size();

        for (int i=0; i<productsCount; i++){
            String originalW = driver.getWindowHandle();
            Set<String> existWs = driver.getWindowHandles();

            String link = products.get(i).findElement(By.cssSelector(".link")).getAttribute("href");

            driver.executeScript("window.open()");
            String newW = wait.until(anyWindowOtherThan(existWs));
            driver.switchTo().window(newW);
            driver.get(link);

            if(isSizeListDisplayed()){
                selectSize(1);
            }
            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();
            waitForElementAttributeEqualsString(driver.findElement(By.cssSelector("[class='badge quantity']")), "textContent", String.valueOf(i+1), driver, 5 );
            driver.close();
            driver.switchTo().window(originalW);
        }
    }

    private ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver input) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(windows);
                return handles.size() >0 ? handles.iterator().next() : null;
            }
        };
    }

    private void selectSize(int i) {
        Select drpSize = new Select(driver.findElement(By.cssSelector("[name = 'options[Size]']")));
        drpSize.selectByIndex(i);
    }

    private List<WebElement> getProducts() {
        return driver.findElements(By.cssSelector("#box-popular-products .product-column"));
    }

    private boolean isSizeListDisplayed() {
        if (driver.findElements(By.cssSelector(".select-wrapper")).size() > 0){
            return true;
        }
        else return false;
    }

    private void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cart"))).click();
    }

    private void deleteFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-id]")));

        List<WebElement> cartProducts = driver.findElements(By.cssSelector("[data-id]"));
        int counter = cartProducts.size();
        System.out.println("number of elements in cart: " + cartProducts.size());

        for (int i=0; i<counter; i++){
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
            wait.until(ExpectedConditions.invisibilityOf(cartProducts.get(0)));
            cartProducts = driver.findElements(By.cssSelector("[data-id]"));
        }

        Assert.assertEquals(driver.findElement(By.cssSelector(("#box-checkout em"))).getAttribute("textContent"),"There are no items in your cart.");
    }

    public void waitForElementAttributeEqualsString(WebElement element, String attribute, String expectedString,
                                                    WebDriver driver, int specifiedTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
        ExpectedCondition<Boolean> elementAttributeEqualsString = arg0 -> element.getAttribute(attribute).equals
                (expectedString);
        wait.until(elementAttributeEqualsString);
    }
}
