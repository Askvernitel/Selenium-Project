package tests.ui;

import io.qameta.allure.*;
import org.project.base.UiTestBase;
import org.project.components.ProductCardComponent;
import org.project.dtos.Account;
import org.project.dtos.Contact;
import org.project.pages.*;
import org.project.utils.FileUtils;
import org.project.utils.TestDataFactory;
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
        Contact contact = TestDataFactory.getContact();

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        ContactUsPage contactUsPage = homePage.clickContactUsButton();

        Assert.assertTrue(contactUsPage.isGetInTouchTextDisplayed());

        pageDirector.getContactUsPageByContact(contactUsPage, contact).clickSubmitButton().acceptAlert();

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
        String searchText = "Blue Top";

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());


        ProductsPage productsPage = homePage.clickProductsButton();

        Assert.assertTrue(productsPage.isAllProductsTextDisplayed());
        Assert.assertTrue(productsPage.isProductDivDisplayed());

        productsPage.setSearchText(searchText).clickSubmitSearchButton();

        Assert.assertTrue(productsPage.isSearchProductsTextDisplayed());

        List<ProductCardComponent> products = productsPage.getProductCards();

        for(ProductCardComponent product:products){
            Assert.assertEquals(product.getProductTitle(), searchText);
        }
    }


    @Test
    @Story("Newsletter Subscription")
    @Description("Verify that users can subscribe to newsletter from footer")
    @Severity(SeverityLevel.NORMAL)
    public void verifySubscription(){
        Account account = TestDataFactory.getAccount();

        HomePage homePage = new HomePage(driver);
        homePage.navigateUrl(HomePage.url);
        Assert.assertTrue(homePage.isDisplayed());

        homePage.scrollToFooter();

        Assert.assertTrue(homePage.isSubscriptionTextVisible());

        homePage.setSubscribeEmail(account.getEmail()).clickSubscriptionButton();

        Assert.assertTrue(homePage.isSuccessfulSubscriptionTextVisible());
    }

}
