package org.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class ProductsPage extends PageBase {
    public static String url = "https://automationexercise.com/products";

    private String allProductsText = "All Products";

    private By productListDivLocator = new By.ByCssSelector("div[class='features_items']");

    private By getProductButtonLocatorByIndex(Integer i){
        return new By.ByCssSelector(String.format("a[href='/product_details/%d']", i+1));
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public ProductDetailPage clickFirstProduct(){
        click(getProductButtonLocatorByIndex(0));
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
