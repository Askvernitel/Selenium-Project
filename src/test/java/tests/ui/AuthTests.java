package tests.ui;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.project.base.UiTestBase;
import org.project.client.AccountClient;
import org.project.dto.Account;
import org.project.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI Tests")
@Feature("Authentication")
public class AuthTests extends UiTestBase {


    @Test(priority = 0)
    @Story("User Registration")
    @Description("Verify that a new user can successfully register an account")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewAccount() {
        Account account = new Account.Builder()
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .build();
        AccountClient accountClient = new AccountClient();
        accountClient.deleteAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignupTextDisplayed());

        SignupPage signupPage = loginPage
                .setSignupName("Daniel")
                .setSignupEmail("DanielTestWA213451@gmail.com")
                .clickSignupButton();
        Assert.assertTrue(signupPage.isInfoTextVisible());

        AccountCreatedPage accountCreatedPage = signupPage.tickMaleRadio()
                .setPassword("TestPassword")
                .setDays("1")
                .setMonth("February")
                .setYear("2006")
                .tickNewsletterCheckbox()
                .tickOfferCheckbox()
                .scrollToSubmitButton()
                .setFirstName("Daniel")
                .setLastName("Kolotashvili")
                .setCompany("CoolSoft")
                .setAddressFirst("Test Addres 1")
                .setAddressSecond("Test Address 2")
                .setCountry("Canada")
                .setState("Canada State")
                .setCity("City")
                .setZipcode("1400")
                .setMobileNumber("5010")
                .clickSubmitButton();

        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextVisible());
        homePage = accountCreatedPage.clickContinueButton();

        Assert.assertTrue(homePage.isTextVisible("Logged in as Daniel"));
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();

        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());

        accountDeletedPage.clickContinueButton();

    }

    @Test(priority = 1)
    @Story("User Login")
    @Description("Verify that a user can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginValidAccount(){
        Account account = new Account.Builder()
                .name("Daniel")
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .title("Mr")
                .birthDate("1")
                .birthMonth("February")
                .birthYear("2006")
                .firstname("Daniel")
                .lastname("Kolotashvili")
                .company("CoolSoft")
                .address1("Test Addres 1")
                .address2("Test Address 2")
                .country("Canada")
                .state("Canada State")
                .city("City")
                .zipcode("1400")
                .mobileNumber("5010")
                .build();
        AccountClient accountClient = new AccountClient();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        homePage = loginPage
                .setLoginEmail("DanielTestWA213451@gmail.com")
                .setLoginPassword("TestPassword")
                .clickLoginButton();

        Assert.assertTrue(homePage.isTextVisible("Logged in as Daniel"));
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());
    }

    @Test(priority = 2)
    @Story("User Login")
    @Description("Verify that login fails with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void loginInvalidAccount() {
        Account account = new Account.Builder()
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .build();
        AccountClient accountClient = new AccountClient();
        Response resp = accountClient.deleteAccount(account);
        System.out.println(resp.getBody().print());
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        loginPage.setLoginEmail("DanielTestWA213451@gmail.com")
                .setLoginPassword("TestPassword")
                .clickLoginButtonNoRedirect();

        Assert.assertTrue(loginPage.isInvalidLoginTextDisplayed());
    }


    @Test(priority = 3)
    @Story("User Logout")
    @Description("Verify that a logged-in user can logout successfully")
    @Severity(SeverityLevel.NORMAL)
    public void logoutAccount(){
        Account account = new Account.Builder()
                .name("Daniel")
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .title("Mr")
                .birthDate("1")
                .birthMonth("February")
                .birthYear("2006")
                .firstname("Daniel")
                .lastname("Kolotashvili")
                .company("CoolSoft")
                .address1("Test Addres 1")
                .address2("Test Address 2")
                .country("Canada")
                .state("Canada State")
                .city("City")
                .zipcode("1400")
                .mobileNumber("5010")
                .build();
        AccountClient accountClient = new AccountClient();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        homePage = loginPage
                .setLoginEmail("DanielTestWA213451@gmail.com")
                .setLoginPassword("TestPassword")
                .clickLoginButton();

        Assert.assertTrue(homePage.isTextVisible("Logged in as Daniel"));

    }
    @Test(priority = 0)
    @Story("User Registration")
    @Description("Verify that registration fails when attempting to register with an existing email")
    @Severity(SeverityLevel.CRITICAL)
    public void registerExistingAccount() {
        Account account = new Account.Builder()
                .name("Daniel")
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .title("Mr")
                .birthDate("1")
                .birthMonth("February")
                .birthYear("2006")
                .firstname("Daniel")
                .lastname("Kolotashvili")
                .company("CoolSoft")
                .address1("Test Addres 1")
                .address2("Test Address 2")
                .country("Canada")
                .state("Canada State")
                .city("City")
                .zipcode("1400")
                .mobileNumber("5010")
                .build();
        AccountClient accountClient = new AccountClient();
        accountClient.createAccount(account);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignupTextDisplayed());

        loginPage.setSignupName("Daniel")
                .setSignupEmail("DanielTestWA213451@gmail.com")
                .clickSignupButtonNoRedirect();
        Assert.assertTrue(loginPage.isInvalidSignupTextDisplayed());
    }




}
