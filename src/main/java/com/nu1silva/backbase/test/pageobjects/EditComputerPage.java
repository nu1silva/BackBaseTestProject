package com.nu1silva.backbase.test.pageobjects;

import com.nu1silva.backbase.test.base.TestBase;
import com.nu1silva.backbase.test.util.ElementLocatorProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * EdirComputerPage provides the locator implementation for EditComputer page
 */
public class EditComputerPage extends TestBase {

    public WebElement txtBoxName() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.edit.txtbox.name")));
    }

    public WebElement txtBoxIntroduced() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.edit.txtbox.introduced")));
    }

    public WebElement txtBoxDiscontinued() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.edit.txtbox.discontinued")));
    }

    public WebElement dropDownCompany() {
        return driver.findElement
                (By.id(ElementLocatorProperties.getInstance().getElement("page.edit.dropdown.company")));
    }

    public WebElement btnSave() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.edit.btn.save")));
    }

    public WebElement btnCancel() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.edit.btn.cancel")));
    }

    public WebElement btnDelete() {
        return driver.findElement
                (By.xpath(ElementLocatorProperties.getInstance().getElement("page.edit.btn.delete")));
    }
}
