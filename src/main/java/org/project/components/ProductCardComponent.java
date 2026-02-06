package org.project.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCardComponent {
    WebElement root;

    private static By productInfoDivLocator = new By.ByCssSelector(".productinfo.text-center");

    public ProductCardComponent(WebElement root){
        this.root = root;
    }


    public String getProductTitle(){
        return root.findElement(productInfoDivLocator).findElement(By.tagName("p")).getText();
    }
}
