
package com.dreamportal.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DreamDiaryPage {

    WebDriver driver;

    By pageHeading = By.tagName("h1");
    By dreamRows = By.cssSelector("table tbody tr");
    By dreamTypes = By.cssSelector("table tbody tr td:nth-child(3)");
    By dreamNames = By.cssSelector("table tbody tr td:nth-child(1)");

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }

    public int getDreamRowCount() {
        return driver.findElements(dreamRows).size();
    }

    public List<WebElement> getDreamTypes() {
        return driver.findElements(dreamTypes);
    }

    public List<String> getDreamNames() {

        List<String> names = new ArrayList<>();

        List<WebElement> elements = driver.findElements(dreamNames);

        for (WebElement element : elements) {
            names.add(element.getText().trim());
        }

        return names;
    }

    public boolean areDreamTypesValid() {

        List<WebElement> types = getDreamTypes();

        for (WebElement type : types) {

            String dreamType = type.getText().trim();

            if (!dreamType.equals("Good") && !dreamType.equals("Bad")) {
                return false;
            }
        }

        return true;
    }

    public boolean areAllDreamRowsComplete() {

        List<WebElement> rows = driver.findElements(dreamRows);

        for (WebElement row : rows) {

            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (columns.size() != 3) {
                return false;
            }

            for (WebElement column : columns) {

                if (column.getText().trim().isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
}
