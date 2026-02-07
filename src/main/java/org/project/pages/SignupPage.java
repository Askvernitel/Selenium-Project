package org.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.project.base.PageBase;

public class SignupPage extends PageBase {
    public static final String url = "https://automationexercise.com/signup";

    String infoText = "Enter Account Information";


    private By maleGenderRadioLocator = new By.ById("id_gender1");
    private By femaleGenderRadioLocator = new By.ById("id_gender2");

    private By passwordInputLocator = new By.ById("password");
    private By firstNameInputLocator = new By.ById("first_name");
    private By lastNameInputLocator = new By.ById("last_name");
    private By companyInputLocator = new By.ById("company");
    private By addressFirstInputLocator = new By.ById("address1");
    private By addressSecondInputLocator = new By.ById("address2");
    private By stateInputLocator = new By.ById("state");
    private By cityInputLocator = new By.ById("city");
    private By zipcodeInputLocator = new By.ById("zipcode");
    private By mobileNumberInputLocator = new By.ById("mobile_number");

    private By daysSelectLocator = new By.ById("days");
    private By monthsSelectLocator = new By.ById("months");
    private By yearsSelectLocator = new By.ById("years");
    private By countrySelectLocator = new By.ById("country");

    private By newsletterCheckboxLocator = new By.ById("newsletter");
    private By offerCheckboxLocator = new By.ById("optin");

    private By submitButtonLocator = new By.ByCssSelector("button[type='submit']");

    public SignupPage(WebDriver driver) {
        super(driver);
    }



    @Step("Set password to '{input}'")
    public SignupPage setPassword(String input){
        input(passwordInputLocator, input);
        return this;
    }

    @Step("Set birth day to '{input}'")
    public SignupPage setDays(String input){
        selectByValue(daysSelectLocator, input);
        return this;
    }

    @Step("Set birth month to '{input}'")
    public SignupPage setMonth(String input){
        selectByVisibleText(monthsSelectLocator, input);
        return this;
    }

    @Step("Set birth year to '{input}'")
    public SignupPage setYear(String input){
        selectByValue(yearsSelectLocator, input);
        return this;
    }

    @Step("Set first name to '{input}'")
    public SignupPage setFirstName(String input) {
        input(firstNameInputLocator, input);
        return this;
    }

    @Step("Set last name to '{input}'")
    public SignupPage setLastName(String input) {
        input(lastNameInputLocator, input);
        return this;
    }

    @Step("Set company to '{input}'")
    public SignupPage setCompany(String input) {
        input(companyInputLocator, input);
        return this;
    }

    @Step("Set first address to '{input}'")
    public SignupPage setAddressFirst(String input) {
        input(addressFirstInputLocator, input);
        return this;
    }

    @Step("Set second address to '{input}'")
    public SignupPage setAddressSecond(String input) {
        input(addressSecondInputLocator, input);
        return this;
    }

    @Step("Set state to '{input}'")
    public SignupPage setState(String input) {
        input(stateInputLocator, input);
        return this;
    }

    @Step("Set city to '{input}'")
    public SignupPage setCity(String input) {
        input(cityInputLocator, input);
        return this;
    }

    @Step("Set zipcode to '{input}'")
    public SignupPage setZipcode(String input) {
        input(zipcodeInputLocator, input);
        return this;
    }

    @Step("Set mobile number to '{input}'")
    public SignupPage setMobileNumber(String input) {
        input(mobileNumberInputLocator, input);
        return this;
    }

    @Step("Set country to '{input}'")
    public SignupPage setCountry(String input) {
        selectByValue(countrySelectLocator, input);
        return this;
    }

    @Step("Select male gender")
    public SignupPage tickMaleRadio(){
        click(maleGenderRadioLocator);
        return this;
    }

    @Step("Select female gender")
    public SignupPage tickFemaleRadio(){
        click(femaleGenderRadioLocator);
        return this;
    }

    @Step("Subscribe to newsletter")
    public SignupPage tickNewsletterCheckbox(){
        click(newsletterCheckboxLocator);
        return this;
    }

    @Step("Subscribe to special offers")
    public SignupPage tickOfferCheckbox(){
        click(offerCheckboxLocator);
        return this;
    }

    @Step("Scroll to submit button")
    public SignupPage scrollToSubmitButton(){
        scrollTo(submitButtonLocator);
        return this;
    }

    @Step("Click submit button to create account")
    public AccountCreatedPage clickSubmitButton() {
        click(submitButtonLocator);
        waitUrlChangeTo(AccountCreatedPage.url);
        return new AccountCreatedPage(driver);
    }

    @Step("Verify 'Enter Account Information' text is visible")
    public Boolean isInfoTextVisible(){
        return isTextVisible(infoText);
    }
}
