package org.project.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.project.enums.DriverType;

public class DriverFactory {


    public static WebDriver getDriverOf(DriverType driverType){
        switch(driverType){
            case CHROME -> {
                return new ChromeDriver();
            }
            case FIREFOX -> {
                FirefoxProfile profile = new FirefoxProfile();

                profile.setPreference("privacy.trackingprotection.enabled", true);
                profile.setPreference("privacy.trackingprotection.socialtracking.enabled", true);
                profile.setPreference("privacy.trackingprotection.cryptomining.enabled", true);
                profile.setPreference("privacy.trackingprotection.fingerprinting.enabled", true);

                profile.setPreference("dom.disable_open_during_load", true);
                profile.setPreference("media.autoplay.default", 5);

                profile.setPreference("dom.webnotifications.enabled", false);

                profile.setPreference("dom.push.enabled", false);

                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                return new FirefoxDriver();
            }
            default -> throw new InvalidArgumentException("Invalid DriverType");
        }
    }
}
