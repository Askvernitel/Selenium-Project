package tests.ui;

import io.qameta.allure.*;
import org.project.base.UiTestBase;
import org.project.components.ProductCardComponent;
import org.project.pages.*;
import org.project.utils.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
@Epic("UI Tests")
@Feature("Page Functionality")
public class PageTests extends UiTestBase {

    @Test
    @Story("Contact Us")
    @Description("Verify that users can submit a contact form with file attachment")
    @Severity(SeverityLevel.NORMAL)
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
    @Story("Test Cases Page")
    @Description("Verify that test cases page is accessible and displays correctly")
    @Severity(SeverityLevel.MINOR)
    public void testCasePage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        TestCasePage testCasePage = homePage.clickTestCaseButton();

        Assert.assertTrue(testCasePage.isTestCaseTextDisplayed());

    }
    @Test
    @Story("Product Details")
    @Description("Verify that product page displays all product information correctly")
    @Severity(SeverityLevel.NORMAL)
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
    @Story("Product Search")
    @Description("Verify that users can search for products and get accurate results")
    @Severity(SeverityLevel.CRITICAL)
    public void searchProduct(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());


        ProductsPage productsPage = homePage.clickProductsButton();

        Assert.assertTrue(productsPage.isAllProductsTextDisplayed());
        Assert.assertTrue(productsPage.isProductDivDisplayed());

        productsPage.setSearchText("Blue Top").clickSubmitSearchButton();

        Assert.assertTrue(productsPage.isSearchProductsTextDisplayed());

        List<ProductCardComponent> products = productsPage.getProductCards();

        for(ProductCardComponent product:products){
            Assert.assertEquals(product.getProductTitle(), "Blue Top");
        }
    }


    @Test
    @Story("Newsletter Subscription")
    @Description("Verify that users can subscribe to newsletter from footer")
    @Severity(SeverityLevel.NORMAL)
    public void verifySubscription(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        homePage.scrollToFooter();

        Assert.assertTrue(homePage.isSubscriptionTextVisible());

        homePage.setSubscribeEmail("Daniel@gmail.com").clickSubscriptionButton();

        Assert.assertTrue(homePage.isSuccessfulSubscriptionTextVisible());
    }

}
