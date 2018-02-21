package com.nu1silva.backbase.test;

import com.nu1silva.backbase.test.base.TestBase;
import com.nu1silva.backbase.test.operations.Computers;
import com.nu1silva.backbase.test.pageobjects.AddComputerPage;
import com.nu1silva.backbase.test.pageobjects.EditComputerPage;
import com.nu1silva.backbase.test.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Testcases created as a regression suite for Computer Database
 */
public class ComputerTest extends TestBase {

    HomePage homePage = new HomePage();
    AddComputerPage addComputerPage = new AddComputerPage();
    EditComputerPage editComputerPage = new EditComputerPage();
    Computers computers = new Computers();

    @Test(priority = 1)
    public void testCreateComputer() {
        int initialTotalComputers = getTotalComputers();
        computers.createComputer("nuwan-pc", "2018-02-20", "2018-02-20", "IBM");
        Assert.assertTrue(driver.getPageSource().contains("Computer nuwan-pc has been created"));
        Assert.assertEquals(getTotalComputers(), initialTotalComputers + 1, "Total number of computers mismatched");
    }

    @Test(priority = 2)
    public void testViewComputer() {
        computers.viewComputer("nuwan-pc");
        Assert.assertEquals(editComputerPage.txtBoxName().getAttribute("value"), "nuwan-pc");
    }

    @Test(priority = 3)
    public void testUpdateComputer() {
        computers.updateComputer("nuwan-pc", "nuwan-pc-update", "2018-02-10",
                "2018-02-28", "Nokia");
        computers.viewComputer("nuwan-pc-update");
        Assert.assertEquals(editComputerPage.txtBoxName().getAttribute("value"), "nuwan-pc-update",
                "computer name mismatched");
        Assert.assertEquals(editComputerPage.txtBoxIntroduced().getAttribute("value"), "2018-02-10",
                "computer name mismatched");
        Assert.assertEquals(editComputerPage.txtBoxDiscontinued().getAttribute("value"), "2018-02-28",
                "computer name mismatched");
        String optionValue = editComputerPage.dropDownCompany().getAttribute("value");
        Select selectCompany = new Select(editComputerPage.dropDownCompany());
        selectCompany.selectByValue(optionValue);
        Assert.assertEquals(selectCompany.getFirstSelectedOption().getText(), "Nokia",
                "computer name mismatched");
    }

    @Test(priority = 4)
    public void testDeleteComputer() {
        int initialTotalComputers = getTotalComputers();
        computers.deleteComputer("nuwan-pc-update");
        Assert.assertTrue(driver.getPageSource().contains("Computer has been deleted"));
        Assert.assertEquals(getTotalComputers(), initialTotalComputers - 1, "Total number of computers mismatched");
    }

    @Test(priority = 5, enabled = false)
    public void testAddComputerWithSameName() {
        computers.createComputer("nuwan-pc-same", "2018-02-20", "2018-02-20", "IBM");
        Assert.assertTrue(driver.getPageSource().contains("Computer nuwan-pc has been created"));

        computers.createComputer("nuwan-pc-same", "2018-02-20", "2018-02-20", "IBM");
        Assert.assertFalse(driver.getPageSource().contains("Computer nuwan-pc has been created"));

        // clean up
        computers.deleteComputer("nuwan-pc-same");
    }

    @Test(priority = 40)
    public void testCreateWithBlankValues() {
        driver.get(APPLICATION_URL);
        homePage.btnAddComputer().click();
        addComputerPage.txtBoxName().sendKeys("");
        addComputerPage.txtBoxIntroduced().sendKeys("");
        addComputerPage.txtBoxDiscontinued().sendKeys("");
        addComputerPage.btnCreate().click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"main\"]/form/fieldset/div[1]/div/span")).getText(),
                "Required", "error message mismatch");
    }

    @Test(priority = 41)
    public void testCreateWithInvalidDateFormat() {
        driver.get(APPLICATION_URL);
        homePage.btnAddComputer().click();
        addComputerPage.txtBoxName().sendKeys("temp");
        addComputerPage.txtBoxIntroduced().sendKeys("2018-02-201");
        addComputerPage.txtBoxDiscontinued().sendKeys("02-20-2018");
        addComputerPage.btnCreate().click();
        Assert.assertTrue(driver.getPageSource().contains("clearfix error"));
    }

    @Test(priority = 50)
    public void testSearchMultipleComputers() {
        computers.createComputer("nuwan-pc-01", "2018-02-20", "2018-02-20", "IBM");
        computers.createComputer("nuwan-pc-02", "2018-02-20", "2018-02-20", "IBM");
        computers.createComputer("nuwan-pc-03", "2018-02-20", "2018-02-20", "IBM");
        homePage.txtBoxSearch().sendKeys("nuwan-pc");
        homePage.btnSearch().click();

        String headerValue = homePage.pageHeader().getText();
        String arr[] = headerValue.split(" ", 2);
        int numberOfResults = Integer.parseInt(arr[0]);

        Assert.assertEquals(numberOfResults, 3, "result number missmatch");

        // Cleanup
        computers.deleteComputer("nuwan-pc-01");
        computers.deleteComputer("nuwan-pc-02");
        computers.deleteComputer("nuwan-pc-03");
    }

    private int getTotalComputers() {
        driver.get(APPLICATION_URL);
        String headerValue = homePage.pageHeader().getText();
        String arr[] = headerValue.split(" ", 2);
        return Integer.parseInt(arr[0]);
    }
}
