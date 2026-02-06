package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.project.base.PageBase;

public class HomePage extends PageBase {
    public static final String url = "https://automationexercise.com/";

    private By.ByCssSelector logoLocator = new By.ByCssSelector("img[src='/static/images/home/logo.png']");

    private By.ByCssSelector loginButtonLocator = new By.ByCssSelector("a[href='/login']");
    private By.ByCssSelector deleteAccountButtonLocator = new By.ByCssSelector("a[href='/delete_account']");
    private By.ByCssSelector contactUsButtonLocator = new By.ByCssSelector("a[href='/contact_us']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public AccountDeletedPage clickDeleteAccountButton(){
        click(deleteAccountButtonLocator);
        waitUrlChangeTo(AccountDeletedPage.url);
        return new AccountDeletedPage(driver);
    }

    public LoginPage clickLoginButton(){
        click(loginButtonLocator);
        waitUrlChangeTo(LoginPage.url);
        return new LoginPage(driver);
    }

    public LoginPage clickLogoutButton(){
        click(loginButtonLocator);
        waitUrlChangeTo(LoginPage.url);
        return new LoginPage(driver);
    }

    public ContactUsPage clickContactUsButton(){
        click(contactUsButtonLocator);
        waitUrlChangeTo(ContactUsPage.url);
        return new ContactUsPage(driver);
    }



    public boolean isDisplayed(){
        return findElement(logoLocator).isDisplayed();
    }



}
