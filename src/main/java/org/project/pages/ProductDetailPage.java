package org.project.pages;

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


    public Boolean isProductNameVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productNameLocator).isDisplayed();
    }

    public Boolean isProductCategoryVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productCategoryLocator).isDisplayed();
    }

    public Boolean isProductPriceVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productPriceLocator).isDisplayed();
    }

    public Boolean isProductAvailabilityVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productAvailabilityLocator).isDisplayed();
    }

    public Boolean isProductConditionVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productConditionLocator).isDisplayed();
    }

    public Boolean isProductBrandVisible(){
        WebElement root = findElement(productInformationDivLocator);
        return root.findElement(productBrandLocator).isDisplayed();
    }
    public Boolean isProductInformationVisible(){
        return isVisible(productInformationDivLocator);
    }
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
        return isProductNameVisible()
                && isProductCategoryVisible()
                && isProductPriceVisible()
                && isProductAvailabilityVisible()
                && isProductConditionVisible()
                && isProductBrandVisible();
    }

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
}
