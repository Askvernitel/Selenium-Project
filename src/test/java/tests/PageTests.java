package tests;

import org.project.base.TestBase;
import org.project.pages.*;
import org.project.utils.FileUtils;
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

        contactUsPage
                .setEmail("Daniel@gmail.com")
                .setName("Daniel")
                .setSubject("Test Subject")
                .setMessage("Test Message")
                .setUploadFilePath(FileUtils.getPathFor("test-files/test.txt"))
                .clickSubmitButton()
                .acceptAlert();

        Assert.assertTrue(contactUsPage.isSuccessfulSubmitTextDisplayed());

        homePage = contactUsPage.clickHomeButton();
        Assert.assertTrue(homePage.isDisplayed());
    }


    @Test
    public void testCasePage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        TestCasePage testCasePage = homePage.clickTestCaseButton();

        Assert.assertTrue(testCasePage.isTestCaseTextDisplayed());

    }
    @Test
    public void productPage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        ProductsPage productsPage = homePage.clickProductsButton();

        Assert.assertTrue(productsPage.isAllProductsTextDisplayed());
        Assert.assertTrue(productsPage.isProductDivDisplayed());

        ProductDetailPage productDetailPage = productsPage.clickFirstProduct();

        Assert.assertTrue(productDetailPage.isProductInformationVisible());
        Assert.assertTrue(productDetailPage.areProductDetailsVisible());
    }

    @Test
    public void productSearch(){

    }

}
