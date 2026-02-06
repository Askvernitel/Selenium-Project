package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class ProductsPage extends PageBase {
    public static String url = "https://automationexercise.com/products";

    private String allProductsText = "All Products";


    private By productListDivLocator = new By.ByCssSelector("div[class='features_items']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public ProductDetailPage clickFirstProduct(){

        waitUrlChangeTo(ProductDetailPage.getUrlByIndex(0));
        return new ProductDetailPage(driver);
    }

    public Boolean isProductDivDisplayed(){
        return isDisplayed(productListDivLocator);
    }
    public Boolean isAllProductsTextDisplayed(){
        return this.isTextVisible(allProductsText);
    }
}
