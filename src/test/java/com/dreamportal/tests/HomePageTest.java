
package com.dreamportal.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dreamportal.base.DriverFactory;
import com.dreamportal.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {

    DriverFactory driverFactory;
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {

        driverFactory = new DriverFactory();
        driverFactory.setup();

        driver = driverFactory.getDriver();

        driver.get("https://arjitnigam.github.io/myDreams/");

        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePageTitle() {

        String title = homePage.getPageTitle();

        System.out.println("Page Title: " + title);

        assertEquals(title, "Dream Portal");
    }

    @Test
    public void verifyLoadingAnimationAppears() {

        boolean displayed = homePage.isLoadingAnimationDisplayed();

        System.out.println("Loading Animation Displayed: " + displayed);

        assertTrue(displayed);
    }
    
    
    @Test
    public void verifyLoadingAnimationDisappears() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(driver -> !homePage.isLoadingAnimationDisplayed());

        System.out.println("Loading Animation Disappeared: true");

        assertTrue(!homePage.isLoadingAnimationDisplayed());
    }
    


    @Test
    public void verifyMainContentAppearsAfterLoading() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(driver -> homePage.isMainContentDisplayed());

        System.out.println("Main Content Displayed: "
                + homePage.isMainContentDisplayed());

        assertTrue(homePage.isMainContentDisplayed());
    }

    @Test
    public void verifyMyDreamsButtonAppearsAfterLoading() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(driver -> homePage.isDreamButtonDisplayed());

        System.out.println("My Dreams Button Displayed: "
                + homePage.isDreamButtonDisplayed());

        assertTrue(homePage.isDreamButtonDisplayed());
    }

    @Test
    public void verifyMyDreamsOpensTwoPages() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(driver -> homePage.isDreamButtonDisplayed());

        String originalWindow = driver.getWindowHandle();

        homePage.clickDreamButton();

        wait.until(driver -> driver.getWindowHandles().size() >= 2);

        Set<String> windows = homePage.getWindowHandles();

        System.out.println("Number of Windows: " + windows.size());

        assertEquals(windows.size(), 3);

        boolean diaryPageFound = false;
        boolean totalPageFound = false;

        for (String window : windows) {

            driver.switchTo().window(window);

            String url = homePage.getCurrentUrl();

            System.out.println("Opened URL: " + url);

            if (url.contains("dreams-diary.html")) {
                diaryPageFound = true;
            }

            if (url.contains("dreams-total.html")) {
                totalPageFound = true;
            }
        }

        assertTrue(diaryPageFound);
        assertTrue(totalPageFound);

        driver.switchTo().window(originalWindow);
    }

    @AfterMethod
    public void tearDown() {

        driverFactory.tearDown();
    }
}
