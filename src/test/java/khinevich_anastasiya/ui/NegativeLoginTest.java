package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import khinevich_anastasiya.ui.util.RandomData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {
    UsersPage userPage = new UsersPage();

    @DataProvider(name = "testInputIncorrectDataForLogIn")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {RandomData.generateRandomName(), RandomData.generateRandomPassword()},
                {RandomData.generateRandomName(), ""},
                {"", RandomData.generateRandomPassword()},
                {"", ""},
                {"^@&^#()", "^@&^#()"},
        };
    }

    @Test(dataProvider = "testInputIncorrectDataForLogIn")
    void testInputIncorrectDataForLogIn(String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForLogIn(email, password);
        Assert.assertTrue(userPage.isTextElementInstructionExist(), "You entered the correct data and logged in ");
    }
}
