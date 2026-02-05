package org.project.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.project.enums.DriverType;

public class DriverFactory {


    public static WebDriver getDriverOf(DriverType driverType){
        switch(driverType){
            case CHROME -> {
                return new ChromeDriver();
            }
            case FIREFOX -> {
                return new FirefoxDriver();
            }
            default -> throw new InvalidArgumentException("Invalid DriverType");
        }
    }
}
