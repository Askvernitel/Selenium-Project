package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.project.base.PageBase;

public class AccountCreatedPage extends PageBase {
    public static final String url = "https://automationexercise.com/account_created";

    String accountCreatedText = "Account Created!";

    By continueButton = new By.ByCssSelector("a[data-qa='continue-button']");
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage(driver);
    }

    public Boolean isAccountCreatedTextVisible(){
        return isTextVisible(accountCreatedText);
    }

}
