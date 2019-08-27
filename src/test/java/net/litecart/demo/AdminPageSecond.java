// Second variant
package net.litecart.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
public class AdminPageSecond extends TestBase {

    @Test
    public void testAllMenuItems(){
        boolean skipTitleChecking;

        List<WebElement> menu = driver.findElements(By.xpath("//li[starts-with(@id,'app')]"));
        int size = menu.size();

        for (int i = 0; i < size; i++){
            String text = menu.get(i).getText();
            if (text.equals("Settings") | text.equals("vQmods")|text.equals("Translations")){
                skipTitleChecking = true;
            } else skipTitleChecking = false;

             menu.get(i).click();

           if (doesSubMenuExists()){
               getSubMenu();
               for (int j = 0; j < getSubMenu().size(); j++){
                   getSubMenu().get(j).click();
                   if (!skipTitleChecking){
                       assertEquals(driver.findElement(By.cssSelector("main#main h1")).getText(),getSubMenu().get(j).getText());
                   }
               }
           } else {
               if (!skipTitleChecking){
                   menu = driver.findElements(By.xpath("//li[starts-with(@id,'app')]"));
                   assertEquals(menu.get(i).getText(),driver.findElement(By.cssSelector("main#main h1")).getText());
               }
           }
           menu = driver.findElements(By.xpath("//li[starts-with(@id,'app')]"));
        }
    }

    public boolean doesSubMenuExists(){
        if (driver.findElements(By.cssSelector("ul.docs li")).size() > 0){
            return true;
        } else return false;
    }

    public List<WebElement> getSubMenu(){
        List<WebElement> submenu = driver.findElements(By.cssSelector("ul.docs li"));
        return submenu;
    }
}
