package org.project.pages;

import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class LoginPage extends PageBase {
    public String signupText = "New User Signup!";

    public LoginPage(WebDriver driver){
        super(driver);
    }




    public boolean isSignupTextDisplayed(){
        return searchByText(signupText).isDisplayed();
    }
}
