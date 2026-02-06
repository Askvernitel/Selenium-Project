package tests;

import org.project.base.TestBase;
import org.project.pages.ContactUsPage;
import org.project.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTests extends TestBase {

    @Test
    public void contactUsPage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());


        ContactUsPage contactUsPage = homePage.clickContactUsButton();

        Assert.assertTrue(contactUsPage.isGetInTouchTextDisplayed());

    }


    @Test
    public void testCasePage(){

    }
    @Test
    public void productPage(){

    }
}
