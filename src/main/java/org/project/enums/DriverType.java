package org.project.enums;

import org.openqa.selenium.InvalidArgumentException;

public enum DriverType {
    FIREFOX, CHROME;


    public static DriverType getFor(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "FIREFOX" -> {
                return FIREFOX;
            }
            case "CHROME" -> {
                return CHROME;
            }
            default -> throw new InvalidArgumentException("Invalid Driver Type");
        }
    }
}
