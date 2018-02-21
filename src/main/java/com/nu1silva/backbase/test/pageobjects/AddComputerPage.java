package com.nu1silva.backbase.test.pageobjects;

import com.nu1silva.backbase.test.base.TestBase;
import com.nu1silva.backbase.test.util.ElementLocatorProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * AddComputerPage provides the locator implementation for AddComputer page
 */
public class AddComputerPage extends TestBase {

    public WebElement txtBoxName() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.add.txtbox.name")));
    }

    public WebElement txtBoxIntroduced() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.add.txtbox.introduced")));
    }

    public WebElement txtBoxDiscontinued() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.add.txtbox.discontinued")));
    }

    public WebElement dropDownCompany() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.add.dropdown.company")));
    }

    public WebElement btnCreate() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.add.btn.create")));
    }

    public WebElement btnCancel() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.add.btn.cancel")));
    }
}
