package org.project.utils;

import org.project.dtos.Account;
import org.project.dtos.Contact;

public class TestDataFactory {


    static {
    }

    public static Account getAccount() {
        return new Account.Builder()
                .name("Daniel")
                .email("DanielTestWA213451@gmail.com")
                .password("TestPassword")
                .title("Mr")
                .birthDate("1")
                .birthMonth("February")
                .birthYear("2006")
                .firstname("Daniel")
                .lastname("Kolotashvili")
                .company("CoolSoft")
                .address1("Test Addres 1")
                .address2("Test Address 2")
                .country("Canada")
                .state("Canada State")
                .city("City")
                .zipcode("1400")
                .mobileNumber("5010")
                .build();
    }


    public static Contact getContact() {
        return new Contact.Builder()
                .email("Daniel@gmail.com")
                .name("Daniel")
                .subject("Test Subject")
                .message("Test Message")
                .uploadFilePath("test-files/test.txt")
                .build();
    }
}
