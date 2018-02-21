package com.nu1silva.backbase.test.operations;

import com.nu1silva.backbase.test.base.TestBase;
import com.nu1silva.backbase.test.pageobjects.AddComputerPage;
import com.nu1silva.backbase.test.pageobjects.EditComputerPage;
import com.nu1silva.backbase.test.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Computers class provides the common set of methods related to the Computer Database
 * which can be used while running tests.
 */
public class Computers extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(Computers.class);

    HomePage homePage = new HomePage();
    AddComputerPage addComputerPage = new AddComputerPage();
    EditComputerPage editComputerPage = new EditComputerPage();

    /**
     * This method will create a computer from the given data
     *
     * @param name
     * @param introduced
     * @param discontinued
     * @param company
     */
    public void createComputer(String name, String introduced, String discontinued, String company) {
        driver.get(APPLICATION_URL);
        homePage.btnAddComputer().click();
        if (driver.getPageSource().contains("Add a computer")) {
            addComputerPage.txtBoxName().sendKeys(name);
            addComputerPage.txtBoxIntroduced().sendKeys(introduced);
            addComputerPage.txtBoxDiscontinued().sendKeys(discontinued);
            Select selectCompany = new Select(addComputerPage.dropDownCompany());
            selectCompany.selectByVisibleText(company);
            addComputerPage.btnCreate().click();
        } else {
            logger.error("Not in the Add Computer page");
        }
    }

    /**
     * This method will delete a computer based on the given name
     *
     * @param name
     */
    public void deleteComputer(String name) {
        viewComputer(name);
        editComputerPage.btnDelete().click();
    }

    /**
     * This method will update the details of a given computer name.
     *
     * @param name
     * @param newName
     * @param introduced
     * @param discontinued
     * @param company
     */
    public void updateComputer(String name, String newName, String introduced, String discontinued, String company) {
        viewComputer(name);
        if (driver.getPageSource().contains("Edit computer")) {
            editComputerPage.txtBoxName().clear();
            editComputerPage.txtBoxName().sendKeys(newName);
            editComputerPage.txtBoxIntroduced().clear();
            editComputerPage.txtBoxIntroduced().sendKeys(introduced);
            editComputerPage.txtBoxDiscontinued().clear();
            editComputerPage.txtBoxDiscontinued().sendKeys(discontinued);
            Select selectCompany = new Select(editComputerPage.dropDownCompany());
            selectCompany.selectByVisibleText(company);
            editComputerPage.btnSave().click();
        } else {
            logger.error("Not in the Edit Computer page");
        }
    }

    /**
     * This method will open a view of a given computer name
     *
     * @param name
     */
    public void viewComputer(String name) {
        driver.get(APPLICATION_URL);
        homePage.txtBoxSearch().sendKeys(name);
        homePage.btnSearch().click();

        int rows = driver.findElements(By.xpath("//*[@id=\"main\"]/table/tbody/tr")).size();

        for (int i = 1; i <= rows; i++) {
            if (driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[" + i + "]/td[1]/a")).getText().contentEquals(name)) {
                driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[" + i + "]/td[1]/a")).click();
            }
        }
    }
}
