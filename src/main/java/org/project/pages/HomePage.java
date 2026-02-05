package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class HomePage extends PageBase {


    public By.ByCssSelector logoLocator = new By.ByCssSelector("img[src='/static/images/home/logo.png']");

    public By.ByCssSelector loginButtonLocator = new By.ByCssSelector("a[href='/login']");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginPage navigateToLogin(){
        click(loginButtonLocator);
        return new LoginPage(driver);
    }



    public boolean isDisplayed(){
        return findElement(logoLocator).isDisplayed();
    }



}
