package org.project.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public WebElement searchByText(String text){
        String xpath = String.format("//*[text()=%s]", text);
        By locator = new By.ByXPath(xpath);
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator);
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
