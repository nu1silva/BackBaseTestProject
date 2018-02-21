package com.nu1silva.backbase.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DriverManager is responsible for providing the driver that would be
 * user for testing based on the OS and browser
 */
public class DriverManager {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private WebDriver driver;

    /**
     * This method will provide the driver implementation based on the OS and Browser
     *
     * @param os
     * @param browser
     * @return WebDriver
     */
    public WebDriver getWebDriver(String os, String browser) {

        if (os.equalsIgnoreCase("windows")) {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers\\chrome\\windows\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "drivers\\gecko\\windows\\geckodriver.exe");
                driver = new FirefoxDriver();
            }

        } else if (os.equalsIgnoreCase("unix")) {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chrome/unix/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "drivers/gecko/unix/geckodriver");
                driver = new FirefoxDriver();
            }

        } else {
            logger.error("Could not find driver for testing");
        }

        return driver;
    }
}
