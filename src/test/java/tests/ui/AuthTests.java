package tests.ui;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.project.base.UiTestBase;
import org.project.client.AccountClient;
import org.project.dtos.Account;
import org.project.pages.*;
import org.project.utils.TestDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI Tests")
@Feature("Authentication")
public class AuthTests extends UiTestBase {

    AccountClient accountClient = new AccountClient();

    @Test(priority = 0)
    @Story("User Registration")
    @Description("Verify that a new user can successfully register an account")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewAccount() {
        Account account = TestDataFactory.getAccount();
        accountClient.deleteAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignupTextDisplayed());

        SignupPage signupPage = pageDirector.getLoginPageByAccount(loginPage, account).clickSignupButton();
        Assert.assertTrue(signupPage.isInfoTextVisible());

        AccountCreatedPage accountCreatedPage = pageDirector.getSignupPageByAccount(signupPage, account).clickSubmitButton();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextVisible());

        homePage = accountCreatedPage.clickContinueButton();
        Assert.assertTrue(homePage.isTextVisible(String.format("Logged in as %s", account.getName())));

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());

        accountDeletedPage.clickContinueButton();
    }

    @Test(priority = 1)
    @Story("User Login")
    @Description("Verify that a user can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginValidAccount(){
        Account account = TestDataFactory.getAccount();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        homePage = pageDirector.getLoginPageByAccount(loginPage, account).clickLoginButton();

        Assert.assertTrue(homePage.isTextVisible(String.format("Logged in as %s", account.getName())));
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());
    }

    @Test(priority = 2)
    @Story("User Login")
    @Description("Verify that login fails with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginInvalidAccount() {
        Account account = TestDataFactory.getAccount();
        accountClient.deleteAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        pageDirector.getLoginPageByAccount(loginPage, account).clickLoginButtonNoRedirect();

        Assert.assertTrue(loginPage.isInvalidLoginTextDisplayed());
    }


    @Test(priority = 3)
    @Story("User Logout")
    @Description("Verify that a logged-in user can logout successfully")
    @Severity(SeverityLevel.NORMAL)
    public void logoutAccount(){
        Account account = TestDataFactory.getAccount();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        homePage = pageDirector.getLoginPageByAccount(loginPage, account).clickLoginButton();

        Assert.assertTrue(homePage.isTextVisible("Logged in as Daniel"));

    }
    @Test(priority = 0)
    @Story("User Registration")
    @Description("Verify that registration fails when attempting to register with an existing email")
    @Severity(SeverityLevel.CRITICAL)
    public void registerExistingAccount() {
        Account account = TestDataFactory.getAccount();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignupTextDisplayed());

        pageDirector.getLoginPageByAccount(loginPage, account).clickSignupButtonNoRedirect();
        Assert.assertTrue(loginPage.isInvalidSignupTextDisplayed());
    }




}
