package net.litecart.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeTask3 {
    EventFiringWebDriver driver;
    static String url = "http://demo.litecart.net///";

    public static final String USERNAME = "alex8790";
    public static final String AUTOMATE_KEY = "xj4zntf6ex2SDpx94Pxd";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void start() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "76.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(URL), caps));
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

        List<WebElement> products = getProducts();      //get list of popular products
        int productsCount = products.size();

        for (int i=0; i<productsCount; i++){            //loop for opening each popular product in new browser tab, adding it into a cart and close that tab
            String originalW = driver.getWindowHandle();
            Set<String> existWs = driver.getWindowHandles();

            String link = products.get(i).findElement(By.cssSelector(".link")).getAttribute("href");        // getting a link of current popular product

            driver.executeScript("window.open()");
            String newW = wait.until(anyWindowOtherThan(existWs));
            driver.switchTo().window(newW);
            driver.get(link);

            if(isSizeListDisplayed()){    // check if dropdown list is displayed, if yes - select Small
                selectSize(1);
            }

            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();          // adding product to a cart
            waitForElementAttributeEqualsString(                                                                    // wait until cart counter will be changed
                                                 driver.findElement(By.cssSelector("[class='badge quantity']")),
                                                "textContent",
                                                 String.valueOf(i+1),
                                                 driver,
                                                5 );
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

    private void selectSize(int i) {            // selecting Size value in dropdown list
        Select drpSize = new Select(driver.findElement(By.cssSelector("[name = 'options[Size]']")));
        drpSize.selectByIndex(i);
    }

    private List<WebElement> getProducts() {            // return list of popular products on main page
        return driver.findElements(By.cssSelector("#box-popular-products .product-column"));
    }

    private boolean isSizeListDisplayed() {         // check if dropdown list is displayed
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-id]")));       // wait until list will be loaded

        List<WebElement> cartProducts = driver.findElements(By.cssSelector("[data-id]"));       // get list of products in cart
        int counter = cartProducts.size();

        System.out.println("number of elements in cart: " + cartProducts.size());

        for (int i=0; i<counter; i++){          // deleting elements one by one from cart
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
            wait.until(ExpectedConditions.invisibilityOf(cartProducts.get(0)));     // wait until elements will be redrawn on the page
            cartProducts = driver.findElements(By.cssSelector("[data-id]"));
        }

        Assert.assertEquals(
                            driver.findElement(By.cssSelector(("#box-checkout em"))).getAttribute("textContent"),
                           "There are no items in your cart.");
    }

    public void waitForElementAttributeEqualsString(WebElement element, String attribute, String expectedString,        // wait for checking when badge will be changed on a cart
                                                    WebDriver driver, int specifiedTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
        ExpectedCondition<Boolean> elementAttributeEqualsString = arg0 -> element.getAttribute(attribute).equals
                (expectedString);
        wait.until(elementAttributeEqualsString);
    }
}
