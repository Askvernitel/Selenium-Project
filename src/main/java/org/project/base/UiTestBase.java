package org.project.base;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v142.page.Page;
import org.project.enums.ConfigType;
import org.project.enums.DriverType;
import org.project.pages.PageDirector;
import org.project.utils.Config;
import org.project.utils.DriverFactory;
import org.project.utils.DriverUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class UiTestBase {
    protected Config config;
    protected WebDriver driver;
    protected PageDirector pageDirector;

    @BeforeClass
    public void setup(ITestContext testContext){
        pageDirector = new PageDirector();
        config = new Config(testContext.getCurrentXmlTest().getAllParameters());

        String browser = config.get(ConfigType.BROWSER);
        driver = DriverFactory.getDriverOf(DriverType.getFor(browser));
    }


    @AfterMethod
    @Story("Failing of Test")
    @Description("Failed Test")
    @Step("Failed Test")
    public void afterFail(ITestResult result){
        if(!result.isSuccess()){
            DriverUtils.screenshot(driver);
        }
    }
    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
