package org.project.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public PageBase(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void click(By locator){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void input(By locator, String input){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
    }


    public void selectByVisibleText(By locator, String text){
        WebElement element = findElement(locator);

        Select select = new Select(element);

        select.selectByVisibleText(text);

    }
    public void selectByValue(By locator, String value){
        WebElement element = findElement(locator);

        Select select = new Select(element);

        select.selectByValue(value);
    }

    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'auto', block:'end'});", element);;
    }

    public void scrollBy(Integer x, Integer y){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);;
    }


    public void navigateUrl(String url){
        this.driver.get(url);
    }

    public WebElement searchByText(String text){
        String xpath = String.format("//*[normalize-space(.)='%s']", text);
        By locator = new By.ByXPath(xpath);
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean isTextVisible(String text){
        return this.searchByText(text).isDisplayed();
    }
    public Boolean isDisplayed(By locator){
        try {
            findElement(locator).isDisplayed();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void waitUrlChangeTo(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement findElement(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }




    public Boolean isVisible(By locator){
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
