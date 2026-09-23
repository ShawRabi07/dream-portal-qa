
package com.dreamportal.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By loadingAnimation = By.id("loadingAnimation");
    By mainContent = By.id("mainContent");
    By dreamButton = By.id("dreamButton");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isLoadingAnimationDisplayed() {
        return driver.findElement(loadingAnimation).isDisplayed();
    }

    public boolean isMainContentDisplayed() {
        return driver.findElement(mainContent).isDisplayed();
    }

    public boolean isDreamButtonDisplayed() {
        return driver.findElement(dreamButton).isDisplayed();
    }

    public void clickDreamButton() {
        driver.findElement(dreamButton).click();
    }

    public int getWindowCount() {
        return driver.getWindowHandles().size();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

