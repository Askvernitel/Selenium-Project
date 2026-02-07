package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.base.PageBase;
import org.project.components.ProductCardComponent;

import java.util.List;

public class ProductsPage extends PageBase {
    public static String url = "https://automationexercise.com/products";

    private String allProductsText = "All Products";
    private String searchedProductsText = "Searched Products";

    private By searchTextInputLocator = new By.ById("search_product");
    private By submitSearchButtonLocator = new By.ById("submit_search");

    private By productListDivLocator = new By.ByCssSelector("div[class='features_items']");

    private By productCardLocator = new By.ByCssSelector("div[class='single-products']");

    private By getProductButtonLocatorByIndex(Integer i){
        return new By.ByCssSelector(String.format("a[href='/product_details/%d']", i+1));
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Enter search text '{input}'")
    public ProductsPage setSearchText(String input){
        input(searchTextInputLocator, input);
        return this;
    }

    @Step("Click on first product")
    public ProductDetailPage clickFirstProduct(){
        click(getProductButtonLocatorByIndex(0));
        waitUrlChangeTo(ProductDetailPage.getUrlByIndex(0));
        return new ProductDetailPage(driver);
    }

    @Step("Get all product cards")
    public List<ProductCardComponent> getProductCards(){
        return findElements(productCardLocator).stream()
                .map(ProductCardComponent::new).toList();
    }

    @Step("Click search submit button")
    public void clickSubmitSearchButton(){
        click(submitSearchButtonLocator);
    }

    @Step("Verify product list is displayed")
    public Boolean isProductDivDisplayed(){
        return isDisplayed(productListDivLocator);
    }

    @Step("Verify 'All Products' text is displayed")
    public Boolean isAllProductsTextDisplayed(){
        return this.isTextVisible(allProductsText);
    }

    @Step("Verify 'Searched Products' text is displayed")
    public Boolean isSearchProductsTextDisplayed(){
        return this.isTextVisible(searchedProductsText);
    }
}
