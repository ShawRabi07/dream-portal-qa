
package com.dreamportal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DreamsTotalPage {

    WebDriver driver;

    By pageHeading = By.tagName("h1");
    By summaryRows = By.cssSelector("#dreamsTotal tbody tr");

    public DreamsTotalPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }

    public int getDreamCount(String dreamType) {

        return Integer.parseInt(
            driver.findElement(
                By.xpath("//table[@id='dreamsTotal']//tr[td[1]='" + dreamType + "']/td[2]")
            ).getText()
        );
    }

    public int getGoodDreamCount() {
        return getDreamCount("Good Dreams");
    }

    public int getBadDreamCount() {
        return getDreamCount("Bad Dreams");
    }

    public int getTotalDreamCount() {
        return getDreamCount("Total Dreams");
    }

    public int getRecurringDreamCount() {
        return getDreamCount("Recurring Dreams");
    }
}
