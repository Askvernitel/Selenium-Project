package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class LoginPage extends PageBase{
    public static final String url = "https://automationexercise.com/login";

    private String signupText = "New User Signup!";
    private String loginText = "Login to your account";



    private By signupNameInputLocator = new By.ByCssSelector("input[data-qa='signup-name']");
    private By signupEmailInputLocator = new By.ByCssSelector("input[data-qa='signup-email']");
    private By loginPasswordInputLocator = new By.ByCssSelector("input[data-qa='login-password']") ;
    private By loginEmailInputLocator = new By.ByCssSelector("input[data-qa='login-email']") ;


    private By signupButtonLocator = new By.ByCssSelector("button[data-qa='signup-button']");
    private By loginButtonLocator = new By.ByCssSelector("button[data-qa='login-button']");
    public LoginPage(WebDriver driver){
        super(driver);
    }


    public LoginPage setSignupName(String input){
        input(signupNameInputLocator, input);
        return this;
    }

    public LoginPage setSignupEmail(String input){
        input(signupEmailInputLocator, input);
        return this;
    }
    public LoginPage setLoginEmail(String input) {
        input(loginEmailInputLocator, input);
        return this;
    }

    public LoginPage setLoginPassword(String input) {
        input(loginPasswordInputLocator, input);
        return this;
    }

    public SignupPage clickSignupButton(){
        click(signupButtonLocator);
        waitUrlChangeTo(SignupPage.url);
        return new SignupPage(driver);
    }

    public HomePage clickLoginButton(){
        click(loginButtonLocator);
        waitUrlChangeTo(HomePage.url);
        return new HomePage(driver);
    }


    public Boolean isSignupTextDisplayed(){
        return isTextVisible(signupText);
    }

    public Boolean isLoginTextDisplayed(){
        return isTextVisible(loginText);
    }
}
