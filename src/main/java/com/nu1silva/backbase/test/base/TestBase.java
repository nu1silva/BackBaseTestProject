package com.nu1silva.backbase.test.base;

import com.nu1silva.backbase.test.util.TestSuiteProperties;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * TestBase class which will initialize the background/environment for testing.
 */
public class TestBase {

    private final static Logger logger = LoggerFactory.getLogger(TestBase.class);

    DriverManager driverManager = new DriverManager();

    protected static WebDriver driver;

    protected static String TESTING_OS;
    protected static String TESTING_BROWSER;
    protected static int DEFAULT_TIMEOUT;
    protected static String APPLICATION_URL;

    @BeforeSuite
    public void setUp() {
        try {
            TESTING_OS = TestSuiteProperties.getInstance().getElement("testing.os");
            TESTING_BROWSER = TestSuiteProperties.getInstance().getElement("testing.browser");
            DEFAULT_TIMEOUT = Integer.parseInt(TestSuiteProperties.getInstance().getElement("default.timeout"));
            APPLICATION_URL = TestSuiteProperties.getInstance().getElement("application.url");

            driver = driverManager.getWebDriver(TESTING_OS, TESTING_BROWSER);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);

        } catch (Exception ex) {
            logger.error("error initializing TestBase", ex.fillInStackTrace());
        }
    }

    @AfterSuite
    public void cleanUp() {
        driver.quit();
    }


}
