package org.project.pages;

import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class ContactUsPage extends PageBase {
    private String getInTouchText = "Get In Touch";

    private String nameInputLocator = "";
    private String emailInputLocator = "";
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }




    public Boolean isGetInTouchTextDisplayed(){
        return this.isTextVisible(getInTouchText);
    }
}
