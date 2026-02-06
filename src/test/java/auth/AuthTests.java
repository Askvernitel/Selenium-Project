package auth;

import org.project.base.TestBase;
import org.project.client.AccountClient;
import org.project.dto.Account;
import org.project.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends TestBase {


    @Test
    public void registerUser() {
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

    @Test
    public void loginUser(){
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


        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginTextDisplayed());

        homePage = loginPage
                .setLoginEmail("danikolotasvili@gmail.com")
                .setLoginPassword("daniel123")
                .clickLoginButton();

        Assert.assertTrue(homePage.isTextVisible("Logged in as Daniel"));
        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccountButton();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());
    }


}
