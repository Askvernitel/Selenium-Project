package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.project.base.PageBase;

public class LoginPage extends PageBase{
    public static final String url = "https://automationexercise.com/login";

    private String signupText = "New User Signup!";

    private By nameInputLocator = new By.ByCssSelector("input[data-qa='signup-name']");
    private By emailInputLocator = new By.ByCssSelector("input[data-qa='signup-email']");

    private By signupButtonLocator = new By.ByCssSelector("button[data-qa='signup-button']");
    public LoginPage(WebDriver driver){
        super(driver);
    }


    public LoginPage setName(String input){
        input(nameInputLocator, input);
        return this;
    }

    public LoginPage setEmail(String input){
        input(emailInputLocator, input);
        return this;
    }

    public SignupPage clickSignupButton(){
        click(signupButtonLocator);
        waitUrlChangeTo(SignupPage.url);
        return new SignupPage(driver);
    }

    public Boolean isSignupTextDisplayed(){
        return isTextVisible(signupText);
    }
}
