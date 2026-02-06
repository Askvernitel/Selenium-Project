package org.project.base;

import org.openqa.selenium.WebDriver;
import org.project.enums.ConfigType;
import org.project.enums.DriverType;
import org.project.utils.Config;
import org.project.utils.DriverFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class UiTestBase {
    protected Config config;
    protected WebDriver driver;


    @BeforeClass
    public void setup(ITestContext testContext){
        config = new Config(testContext.getCurrentXmlTest().getAllParameters());

        String browser = config.get(ConfigType.BROWSER);
        driver = DriverFactory.getDriverOf(DriverType.getFor(browser));
    }


    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
