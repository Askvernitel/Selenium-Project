package org.project.pages;

import io.qameta.allure.Step;
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


    @Step("Click continue button")
    public HomePage clickContinueButton() {
        click(continueButton);
        waitUrlChangeTo(HomePage.url);
        return new HomePage(driver);
    }

    @Step("Verify 'Account Deleted!' text is visible")
    public Boolean isAccountDeletedTextVisible(){
        return isTextVisible(accountDeletedText);
    }
}