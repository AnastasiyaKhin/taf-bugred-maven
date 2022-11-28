package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.driver.Driver;
import khinevich_anastasiya.ui.page.BasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setup() {
        new BasePage().openPage();
    }

    @AfterClass
    public void closeWebDiver() {
        Driver.closeDriver();
    }
}
