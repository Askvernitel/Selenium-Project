package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.base.PageBase;

public class ProductDetailPage extends PageBase {
    private static String url = "https://automationexercise.com/product_details";

    private By productInformationDivLocator = new By.ByCssSelector("div[class='product-information']");

    private By productNameLocator = new By.ByTagName("h2");
    private By productCategoryLocator = new By.ByXPath("//p[contains(normalize-space(.), 'Category')]");
    private By productPriceLocator = new By.ByXPath("//span[contains(normalize-space(.), 'Rs.')]");
    private By productAvailabilityLocator = new By.ByXPath("//p[contains(normalize-space(.), 'Availability')]");
    private By productConditionLocator = new By.ByXPath("//p[contains(normalize-space(.), 'Condition')]");
    private By productBrandLocator = new By.ByXPath("//p[contains(normalize-space(.), 'Brand')]");

    public static String getUrlByIndex(Integer i){
        return url + "/" + (i+1);
    }


    @Step("Verify product name is visible")
    public Boolean isProductNameVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productNameLocator).isDisplayed();
    }

    @Step("Verify product category is visible")
    public Boolean isProductCategoryVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productCategoryLocator).isDisplayed();
    }

    @Step("Verify product price is visible")
    public Boolean isProductPriceVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productPriceLocator).isDisplayed();
    }

    @Step("Verify product availability is visible")
    public Boolean isProductAvailabilityVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productAvailabilityLocator).isDisplayed();
    }

    @Step("Verify product condition is visible")
    public Boolean isProductConditionVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productConditionLocator).isDisplayed();
    }

    @Step("Verify product brand is visible")
    public Boolean isProductBrandVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productBrandLocator).isDisplayed();
    }

    @Step("Verify product information section is visible")
    public Boolean isProductInformationVisible(){
        return isVisible(productInformationDivLocator);
    }

    @Step("Verify all product details are visible")
    public Boolean areProductDetailsVisible(){
        Boolean nameVisible = isProductNameVisible();
        Boolean categoryVisible = isProductCategoryVisible();
        Boolean priceVisible = isProductPriceVisible();
        Boolean availabilityVisible = isProductAvailabilityVisible();
        Boolean conditionVisible = isProductConditionVisible();
        Boolean brandVisible = isProductBrandVisible();

        System.out.println("Product Name Visible: " + nameVisible);
        System.out.println("Product Category Visible: " + categoryVisible);
        System.out.println("Product Price Visible: " + priceVisible);
        System.out.println("Product Availability Visible: " + availabilityVisible);
        System.out.println("Product Condition Visible: " + conditionVisible);
        System.out.println("Product Brand Visible: " + brandVisible);

        return nameVisible && categoryVisible && priceVisible &&
                availabilityVisible && conditionVisible && brandVisible;
    }

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
}
