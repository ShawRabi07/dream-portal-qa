
package com.dreamportal.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dreamportal.base.DriverFactory;
import com.dreamportal.pages.DreamDiaryPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DreamDiaryPageTest {

    DriverFactory driverFactory;
    WebDriver driver;
    DreamDiaryPage dreamDiaryPage;

    @BeforeMethod
    public void setUp() {
        driverFactory = new DriverFactory();
        driverFactory.setup();

        driver = driverFactory.getDriver();

        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

        dreamDiaryPage = new DreamDiaryPage(driver);
    }

    @Test
    public void verifyDreamDiaryPageTitle() {
        String title = dreamDiaryPage.getPageTitle();

        System.out.println("Page Title: " + title);

        assertEquals(title, "Dreams Diary");
    }

    @Test
    public void verifyDreamDiaryPageHeading() {
        String heading = dreamDiaryPage.getPageHeading();

        System.out.println("Page Heading: " + heading);

        assertEquals(heading, "Dreams Diary");
    }

    @Test
    public void verifyDreamCount() {
        int dreamCount = dreamDiaryPage.getDreamRowCount();

        System.out.println("Dream Count: " + dreamCount);

        assertEquals(dreamCount, 10);
    }

    @Test
    public void verifyDreamTypes() {
        boolean validTypes = dreamDiaryPage.areDreamTypesValid();

        System.out.println("Dream Types Valid: " + validTypes);

        assertTrue(validTypes);
    }

    @Test
    public void verifyDreamTableData() {
        boolean completeRows = dreamDiaryPage.areAllDreamRowsComplete();

        System.out.println("All Dream Rows Complete: " + completeRows);

        assertTrue(completeRows);
    }

    @AfterMethod
    public void tearDown() {
        driverFactory.tearDown();
    }
}