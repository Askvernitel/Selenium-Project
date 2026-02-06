package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class AccountDeletedPage extends PageBase {
    public static final String url = "https://automationexercise.com/delete_account";

    String accountDeletedText = "Account Deleted!";

    By continueButton = new By.ByCssSelector("a[data-qa='continue-button']");
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        waitUrlChangeTo(HomePage.url);
        return new HomePage(driver);
    }

    public Boolean isAccountDeletedTextVisible(){
        return isTextVisible(accountDeletedText);
    }

}