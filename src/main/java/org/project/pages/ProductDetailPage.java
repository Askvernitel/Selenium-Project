package org.project.pages;

import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class ProductDetailPage extends PageBase {
    private static String url = "https://automationexercise.com/product_details";
    public static String getUrlByIndex(Integer i){
        return url + "/" + i;
    }

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
}
