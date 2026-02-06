package org.project.pages;

import org.openqa.selenium.WebDriver;
import org.project.base.PageBase;

public class TestCasePage extends PageBase {
    public static final String url = "https://automationexercise.com/test_cases";


    private String testCaseText = "Test Cases";

    public TestCasePage(WebDriver driver) {
        super(driver);
    }


    public Boolean isTestCaseTextDisplayed(){
        return isTextVisible(testCaseText);
    }
}
