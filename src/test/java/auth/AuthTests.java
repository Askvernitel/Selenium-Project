package auth;

import org.project.base.TestBase;
import org.project.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends TestBase {


    @Test
    public void registerUser() {
        //String homePageUrl = config.get(ConfigType.HOMEPAGE_URL);

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isSignupTextDisplayed());

        SignupPage signupPage = loginPage
                .setName("Daniel")
                .setEmail("DanielTestWA213451@gmail.com")
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
        HomePage homePage1 = accountCreatedPage.clickContinueButton();

        Assert.assertTrue(homePage1.isTextVisible("Logged in as Daniel"));
        AccountDeletedPage accountDeletedPage = homePage1.clickDeleteAccountButton();

        Assert.assertTrue(accountDeletedPage.isAccountDeletedTextVisible());

        accountDeletedPage.clickContinueButton();

    }


}
