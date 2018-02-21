package com.nu1silva.backbase.test.pageobjects;

import com.nu1silva.backbase.test.base.TestBase;
import com.nu1silva.backbase.test.util.ElementLocatorProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * HomePage provides the locator implementation for Home page
 */
public class HomePage extends TestBase {

    public WebElement pageHeader() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.home.header")));
    }

    public WebElement txtBoxSearch() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.home.txtbox.search")));
    }

    public WebElement btnSearch() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.home.btn.search")));
    }

    public WebElement btnAddComputer() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.home.btn.addComputer")));
    }
}
