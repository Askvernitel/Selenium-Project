package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.base.PageBase;

public class ContactUsPage extends PageBase {
    public static final String url = "https://automationexercise.com/contact_us";

    private String getInTouchText = "Get In Touch";
    private String successfulSubmitText = "Success! Your details have been submitted successfully.";

    private By nameInputLocator = new By.ByCssSelector("input[data-qa='name']");
    private By emailInputLocator = new By.ByCssSelector("input[data-qa='email']");
    private By subjectInputLocator = new By.ByCssSelector("input[data-qa='subject']");
    private By messageInputLocator = new By.ByCssSelector("textarea[data-qa='message']");
    private By fileInputLocator = new By.ByCssSelector("input[type='file']");

    private By submitButtonLocator = new By.ByCssSelector("input[data-qa='submit-button']");
    private By homeButtonLocator = new By.ByCssSelector("a[class='btn btn-success'][href='/']");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter name '{input}'")
    public ContactUsPage setName(String input) {
        input(nameInputLocator, input);
        return this;
    }

    @Step("Enter email '{input}'")
    public ContactUsPage setEmail(String input) {
        input(emailInputLocator, input);
        return this;
    }

    @Step("Enter subject '{input}'")
    public ContactUsPage setSubject(String input) {
        input(subjectInputLocator, input);
        return this;
    }

    @Step("Enter message '{input}'")
    public ContactUsPage setMessage(String input) {
        input(messageInputLocator, input);
        return this;
    }

    @Step("Upload file from path '{filePath}'")
    public ContactUsPage setUploadFilePath(String filePath){
        WebElement element = findElement(fileInputLocator);
        element.sendKeys(filePath);
        return this;
    }

    @Step("Click submit button")
    public ContactUsPage clickSubmitButton(){
        click(submitButtonLocator);
        return this;
    }

    @Step("Click home button")
    public HomePage clickHomeButton(){
        click(homeButtonLocator);
        waitUrlChangeTo(HomePage.url);
        return new HomePage(driver);
    }

    @Step("Accept alert")
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    @Step("Verify 'Get In Touch' text is displayed")
    public Boolean isGetInTouchTextDisplayed(){
        return this.isTextVisible(getInTouchText);
    }

    @Step("Verify successful submission message is displayed")
    public Boolean isSuccessfulSubmitTextDisplayed(){
        return this.isTextVisible(successfulSubmitText);
    }
}
