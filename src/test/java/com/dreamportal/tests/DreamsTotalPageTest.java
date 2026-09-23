
package com.dreamportal.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dreamportal.base.DriverFactory;
import com.dreamportal.pages.DreamDiaryPage;
import com.dreamportal.pages.DreamsTotalPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DreamsTotalPageTest {

    DriverFactory driverFactory;
    WebDriver driver;
    DreamsTotalPage dreamsTotalPage;
    DreamDiaryPage dreamDiaryPage;

    @BeforeMethod
    public void setUp() {

        driverFactory = new DriverFactory();
        driverFactory.setup();

        driver = driverFactory.getDriver();

        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");

        dreamsTotalPage = new DreamsTotalPage(driver);
    }

    @Test
    public void verifyDreamsTotalPageTitle() {

        String title = dreamsTotalPage.getPageTitle();

        System.out.println("Page Title: " + title);

        assertEquals(title, "Dreams Total");
    }

    @Test
    public void verifyDreamsTotalPageHeading() {

        String heading = dreamsTotalPage.getPageHeading();

        System.out.println("Page Heading: " + heading);

        assertEquals(heading, "Dreams Summary");
    }

    @Test
    public void verifyGoodDreamCount() {

        int count = dreamsTotalPage.getGoodDreamCount();

        System.out.println("Good Dreams: " + count);

        assertEquals(count, 6);
    }

    @Test
    public void verifyBadDreamCount() {

        int count = dreamsTotalPage.getBadDreamCount();

        System.out.println("Bad Dreams: " + count);

        assertEquals(count, 4);
    }

    @Test
    public void verifyTotalDreamCount() {

        int count = dreamsTotalPage.getTotalDreamCount();

        System.out.println("Total Dreams: " + count);

        assertEquals(count, 10);
    }

    @Test
    public void verifyRecurringDreamCount() {

        int count = dreamsTotalPage.getRecurringDreamCount();

        System.out.println("Recurring Dreams: " + count);

        assertEquals(count, 2);
    }

    @Test
    public void verifyRecurringDreamNames() {

        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

        dreamDiaryPage = new DreamDiaryPage(driver);

        List<String> dreamNames = dreamDiaryPage.getDreamNames();

        Map<String, Integer> dreamFrequency = new HashMap<>();

        for (String dreamName : dreamNames) {

            dreamFrequency.put(
                dreamName,
                dreamFrequency.getOrDefault(dreamName, 0) + 1
            );
        }

        int recurringCount = 0;

        for (Map.Entry<String, Integer> entry : dreamFrequency.entrySet()) {

            if (entry.getValue() > 1) {
                recurringCount++;

                System.out.println(
                    "Recurring Dream: " + entry.getKey()
                    + " | Count: " + entry.getValue()
                );
            }
        }

        assertEquals(recurringCount, 2);

        assertTrue(
            dreamFrequency.getOrDefault("Flying over mountains", 0) > 1
        );

        assertTrue(
            dreamFrequency.getOrDefault("Lost in maze", 0) > 1
        );
    }

    @AfterMethod
    public void tearDown() {

        driverFactory.tearDown();
    }
}

