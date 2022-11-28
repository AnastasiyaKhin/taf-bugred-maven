package khinevich_anastasiya.ui.page;

import khinevich_anastasiya.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private static final String URL = "http://users.bugred.ru/";

    public BasePage() {
        this.driver = Driver.getInstance();
    }

    public void openPage() {
        driver.navigate().to(URL);
    }

    protected void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        String actualResult = driver.findElement(locator).getText();
        return actualResult;
    }
}

