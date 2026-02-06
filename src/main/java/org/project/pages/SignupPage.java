package org.project.pages;

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


    public SignupPage setPassword(String input){
        input(passwordInputLocator, input);
        return this;
    }

    public SignupPage setDays(String input){
        selectByValue(daysSelectLocator, input);
        return this;
    }


    public SignupPage setMonth(String input){
        selectByVisibleText(monthsSelectLocator, input);
        return this;
    }

    public SignupPage setYear(String input){
        selectByValue(yearsSelectLocator, input);
        return this;
    }
    public SignupPage setFirstName(String input) {
        input(firstNameInputLocator, input);
        return this;
    }

    public SignupPage setLastName(String input) {
        input(lastNameInputLocator, input);
        return this;
    }

    public SignupPage setCompany(String input) {
        input(companyInputLocator, input);
        return this;
    }

    public SignupPage setAddressFirst(String input) {
        input(addressFirstInputLocator, input);
        return this;
    }

    public SignupPage setAddressSecond(String input) {
        input(addressSecondInputLocator, input);
        return this;
    }

    public SignupPage setState(String input) {
        input(stateInputLocator, input);
        return this;
    }

    public SignupPage setCity(String input) {
        input(cityInputLocator, input);
        return this;
    }

    public SignupPage setZipcode(String input) {
        input(zipcodeInputLocator, input);
        return this;
    }

    public SignupPage setMobileNumber(String input) {
        input(mobileNumberInputLocator, input);
        return this;
    }

    public SignupPage setCountry(String input) {
        selectByValue(countrySelectLocator, input);
        return this;
    }


    public SignupPage tickMaleRadio(){
        click(maleGenderRadioLocator);
        return this;
    }

    public SignupPage tickFemaleRadio(){
        click(femaleGenderRadioLocator);
        return this;
    }

    public SignupPage tickNewsletterCheckbox(){
        click(newsletterCheckboxLocator);
        return this;
    }

    public SignupPage tickOfferCheckbox(){
        click(offerCheckboxLocator);
        return this;
    }

    public SignupPage scrollToSubmitButton(){
        scrollTo(submitButtonLocator);
        return this;
    }

    public AccountCreatedPage clickSubmitButton() {
        click(submitButtonLocator);
        waitUrlChangeTo(AccountCreatedPage.url);
        return new AccountCreatedPage(driver);
    }



    public Boolean isInfoTextVisible(){
        return isTextVisible(infoText);
    }
}
