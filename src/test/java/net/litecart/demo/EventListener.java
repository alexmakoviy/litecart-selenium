package net.litecart.demo;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


import java.io.File;
import java.io.IOException;

public class EventListener extends AbstractWebDriverEventListener {

     @Override
    public void onException(Throwable throwable, WebDriver driver) {
         System.out.println("[Some problems here:] "+throwable.getMessage().split(":")[0]);


         File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         try {
             Files.copy(tempFile, new File(System.currentTimeMillis() + "screen.png"));
         } catch (IOException e) {
             e.printStackTrace();
         }

         System.out.println("[Screenshot captured]");
     }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("[Clicking the element " + element + "]");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("[Searching for element " + by + "]");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("[Element found: " + by + "]");
    }

}
