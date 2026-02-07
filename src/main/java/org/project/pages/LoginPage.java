package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class LoginPage extends PageBase{
    public static final String url = "https://automationexercise.com/login";

    private String signupText = "New User Signup!";
    private String loginText = "Login to your account";
    private String invalidLoginText = "Your email or password is incorrect!";
    private String invalidSignupText = "Email Address already exist!";


    private By signupNameInputLocator = new By.ByCssSelector("input[data-qa='signup-name']");
    private By signupEmailInputLocator = new By.ByCssSelector("input[data-qa='signup-email']");
    private By loginPasswordInputLocator = new By.ByCssSelector("input[data-qa='login-password']") ;
    private By loginEmailInputLocator = new By.ByCssSelector("input[data-qa='login-email']") ;


    private By signupButtonLocator = new By.ByCssSelector("button[data-qa='signup-button']");
    private By loginButtonLocator = new By.ByCssSelector("button[data-qa='login-button']");
    public LoginPage(WebDriver driver){
        super(driver);
    }


    @Step("Enter signup name '{input}'")
    public LoginPage setSignupName(String input){
        input(signupNameInputLocator, input);
        return this;
    }

    @Step("Enter signup email '{input}'")
    public LoginPage setSignupEmail(String input){
        input(signupEmailInputLocator, input);
        return this;
    }

    @Step("Enter login email '{input}'")
    public LoginPage setLoginEmail(String input) {
        input(loginEmailInputLocator, input);
        return this;
    }

    @Step("Enter login password")
    public LoginPage setLoginPassword(String input) {
        input(loginPasswordInputLocator, input);
        return this;
    }

    @Step("Click signup button")
    public SignupPage clickSignupButton(){
        click(signupButtonLocator);
        waitUrlChangeTo(SignupPage.url);
        return new SignupPage(driver);
    }

    @Step("Click login button")
    public HomePage clickLoginButton(){
        click(loginButtonLocator);
        waitUrlChangeTo(HomePage.url);
        return new HomePage(driver);
    }

    @Step("Verify 'New User Signup!' text is displayed")
    public Boolean isSignupTextDisplayed(){
        return isTextVisible(signupText);
    }

    @Step("Verify 'Login to your account' text is displayed")
    public Boolean isLoginTextDisplayed(){
        return isTextVisible(loginText);
    }

    @Step("Verify invalid login error message is displayed")
    public Boolean isInvalidLoginTextDisplayed(){
        return isTextVisible(invalidLoginText);
    }

    @Step("Verify invalid signup error message is displayed")
    public Boolean isInvalidSignupTextDisplayed(){
        return isTextVisible(invalidSignupText);
    }

    @Step("Click login button without redirect")
    public void clickLoginButtonNoRedirect() {
        click(loginButtonLocator);
    }

    @Step("Click signup button without redirect")
    public void clickSignupButtonNoRedirect(){
        click(signupButtonLocator);
    }
}
