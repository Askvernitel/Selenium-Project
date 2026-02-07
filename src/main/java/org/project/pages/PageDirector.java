package org.project.pages;

import org.project.dtos.Account;
import org.project.dtos.Contact;
import org.project.utils.FileUtils;

public class PageDirector {

    public SignupPage getSignupPageByAccount(SignupPage signupPage, Account account) {
        return signupPage.tickMaleRadio()
                .setPassword(account.getPassword())
                .setDays(account.getBirthDate())
                .setMonth(account.getBirthMonth())
                .setYear(account.getBirthYear())
                .tickNewsletterCheckbox()
                .tickOfferCheckbox()
                .scrollToSubmitButton()
                .setFirstName(account.getFirstname())
                .setLastName(account.getLastname())
                .setCompany(account.getCompany())
                .setAddressFirst(account.getAddress1())
                .setAddressSecond(account.getAddress2())
                .setCountry(account.getCountry())
                .setState(account.getState())
                .setCity(account.getCity())
                .setZipcode(account.getZipcode())
                .setMobileNumber(account.getMobileNumber());
    }


    public LoginPage getLoginPageByAccount(LoginPage loginPage, Account account){
        return loginPage
                .setSignupName(account.getName())
                .setSignupEmail(account.getEmail());

    }

    public ContactUsPage getContactUsPageByContact(ContactUsPage contactUsPage, Contact contact){
        return contactUsPage
                .setEmail(contact.getEmail())
                .setName(contact.getName())
                .setSubject(contact.getSubject())
                .setMessage(contact.getMessage())
                .setUploadFilePath(FileUtils.getPathFor(contact.getUploadFilePath()));
    }
}
