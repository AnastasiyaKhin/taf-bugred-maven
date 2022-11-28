package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {
    UsersPage loginPage = new UsersPage();

    @DataProvider(name = "testInputIncorrectDataForLogIn")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphanumeric(6)},
                {RandomStringUtils.randomAlphanumeric(5), ""},
                {"", RandomStringUtils.randomAlphabetic(5)},
                {"", ""},
                {"^@&^#()", "^@&^#()"},
                {"1234566@gmail.ru", "11111"}
        };
    }

    @Test(dataProvider = "testInputIncorrectDataForLogIn")
    void testInputIncorrectDataForLogIn(String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForLogIn(email, password);
        Assert.assertTrue(loginPage.isTextElementInstructionExist(), "You entered the correct data and logged in ");
    }
}
