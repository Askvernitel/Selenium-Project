package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class HomePage extends PageBase {
    public static final String url = "https://automationexercise.com/";

    private String subscriptionText = "Subscription";
    private String successfulSubscriptionText = "You have been successfully subscribed!";

    private By logoLocator = new By.ByCssSelector("img[src='/static/images/home/logo.png']");

    private By loginButtonLocator = new By.ByCssSelector("a[href='/login']");
    private By deleteAccountButtonLocator = new By.ByCssSelector("a[href='/delete_account']");
    private By contactUsButtonLocator = new By.ByCssSelector("a[href='/contact_us']");
    private By testCaseButtonLocator = new By.ByCssSelector("a[href='/test_cases']");
    private By productsButtonLocator = new By.ByCssSelector("a[href='/products']");
    private By subscriptionButtonLocator = new By.ById("subscribe");

    private By subscriptionEmailInputLocator = new By.ById("susbscribe_email");

    private By footerLocator = new By.ById("footer");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter subscription email '{input}'")
    public HomePage setSubscribeEmail(String input) {
        input(subscriptionEmailInputLocator, input);
        return this;
    }

    @Step("Scroll to footer")
    public HomePage scrollToFooter() {
        scrollTo(footerLocator);
        return this;
    }

    @Step("Click 'Delete Account' button")
    public AccountDeletedPage clickDeleteAccountButton() {
        click(deleteAccountButtonLocator);
        waitUrlChangeTo(AccountDeletedPage.url);
        return new AccountDeletedPage(driver);
    }

    @Step("Click 'Login' button")
    public LoginPage clickLoginButton() {
        click(loginButtonLocator);
        waitUrlChangeTo(LoginPage.url);
        return new LoginPage(driver);
    }

    @Step("Click 'Logout' button")
    public LoginPage clickLogoutButton() {
        click(loginButtonLocator);
        waitUrlChangeTo(LoginPage.url);
        return new LoginPage(driver);
    }

    @Step("Click 'Contact Us' button")
    public ContactUsPage clickContactUsButton() {
        click(contactUsButtonLocator);
        waitUrlChangeTo(ContactUsPage.url);
        return new ContactUsPage(driver);
    }

    @Step("Click 'Test Cases' button")
    public TestCasePage clickTestCaseButton() {
        click(testCaseButtonLocator);
        waitUrlChangeTo(TestCasePage.url);
        return new TestCasePage(driver);
    }

    @Step("Click 'Products' button")
    public ProductsPage clickProductsButton() {
        click(productsButtonLocator);
        waitUrlChangeTo(ProductsPage.url);
        return new ProductsPage(driver);
    }

    @Step("Click subscription button")
    public void clickSubscriptionButton() {
        click(subscriptionButtonLocator);
    }

    @Step("Verify 'Subscription' text is visible")
    public Boolean isSubscriptionTextVisible() {
        return isTextVisible(subscriptionText);
    }

    @Step("Verify successful subscription message is visible")
    public Boolean isSuccessfulSubscriptionTextVisible() {
        return isTextVisible(successfulSubscriptionText);
    }

    @Step("Verify home page is displayed")
    public Boolean isDisplayed() {
        return findElement(logoLocator).isDisplayed();
    }


}
