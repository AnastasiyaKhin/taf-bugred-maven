package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeRegistrationTest extends BaseTest {
    UsersPage loginPage = new UsersPage();

    @DataProvider(name = "testInputIncorrectDataForRegistration")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {"", "", ""},
                {RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(6)},
                {"", RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphanumeric(5)},
                {RandomStringUtils.randomAlphanumeric(5), "", RandomStringUtils.randomAlphabetic(6)},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphanumeric(5), ""},
                {RandomStringUtils.randomAlphanumeric(20), RandomStringUtils.randomAlphanumeric(20), RandomStringUtils.randomAlphanumeric(20)},
                {RandomStringUtils.randomAlphabetic(20), RandomStringUtils.randomAlphabetic(20), RandomStringUtils.randomAlphabetic(20)},
                {"^@&^#()!@#$%^&*()_+", "^@&^#()!@#$%^&*()_+", "^@&^#()!@#$%^&*()_+"}
        };
    }

    @Test(dataProvider = "testInputIncorrectDataForRegistration")
    void testInputIncorrectDataForRegistration(String name, String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForRegistration(name, email, password);
        Assert.assertTrue(loginPage.isTextElementInstructionExist(), "You entered the correct data and registration cancelled");
    }
}

