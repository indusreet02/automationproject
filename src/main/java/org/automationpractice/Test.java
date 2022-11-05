package org.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test extends Base{

    public static WebDriver launchChromeBrowser(String url){
        System.setProperty("webdriver.chrome.driver", ".//src//main//resources//driver//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get(url);
        System.out.println("Loaded Url in chrome Browser");
        driver.manage().window().maximize();
        return driver;
    }
    public static void click(String key, WebDriver driver){
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(150));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
        WebElement clickElement = driver.findElement(By.xpath(obj));
        clickElement.click();
        System.out.println(key + " is clicked");
    }

    public static  void  colorselection(String key, WebDriver driver){
        Base bobj= new Base();
        String obj= bobj.getPropertyKeyValue(key);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
        WebElement selectcolor=driver.findElement(By.xpath(obj));
        selectcolor.click();
        System.out.println(key + "is filtered");
    }

    public static void switchFrame(String key, WebDriver driver){
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebElement Frame= driver.findElement(By.xpath(obj));
        driver.switchTo().frame(Frame);
        System.out.println("Switch to frame");
    }
    public static void isDisplayed(String key, WebDriver driver) {
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
        WebElement displayObj = driver.findElement(By.xpath(obj));
        if (displayObj.isDisplayed()) {
            System.out.println(key + " is displayed successfully");
        }
    }

    public static void verifyAmount(String key, String expectedAmount, WebDriver driver) {
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
        WebElement displayObj = driver.findElement(By.xpath(obj));
        String actualAmount = displayObj.getText();
        if (expectedAmount.equals(actualAmount)){
            System.out.println("ExpectedAmount(" + expectedAmount + ") is successfully match with ActualAmount("+ actualAmount+")");
        }
    }

    public static void verifyCartQuantity(String key, WebDriver driver) {
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
        WebElement displayObj = driver.findElement(By.xpath(obj));
        String numberOfItemsInCartText= displayObj.getText();
        System.out.println(numberOfItemsInCartText);
    }


    public static void selectDropdown(String key, String size, WebDriver driver){
        Base bobj= new Base();
        String obj=bobj.getPropertyKeyValue(key);
        WebElement selectObj=driver.findElement(By.xpath(obj));
        Select dropDown= new Select(selectObj);
        dropDown.selectByVisibleText(size);
        System.out.println("size " + size + "" +" is selected");
    }

    public static void mouseOver(String key, int selection, WebDriver driver){
        Base bobj= new Base();
        String obj= bobj.getPropertyKeyValue(key);
        WebElement actionObj= driver.findElement(By.xpath(obj));
        Actions act= new Actions(driver);
        act.clickAndHold(actionObj).perform();
        System.out.println("Dress is hovered successfully");

        if(selection==1) {
            String obj1 = bobj.getPropertyKeyValue(key);
            WebElement clickObj = driver.findElement(By.xpath(("(//a[text()='Evening Dresses'])[2]")));
            clickObj.click();
            System.out.println("Evening Dresses option is clicked successfully");
        }
        if(selection==2){
            String obj1 = bobj.getPropertyKeyValue(key);
            WebElement clickObj = driver.findElement(By.xpath(("(//a[text()='Summer Dresses'])[2]")));
            clickObj.click();
            System.out.println("Evening Dresses option is clicked successfully");
        }
    }
}
