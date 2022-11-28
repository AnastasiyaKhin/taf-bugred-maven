package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import khinevich_anastasiya.ui.util.RandomData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveRegistrationTest extends BaseTest {
    UsersPage loginPage = new UsersPage();

    @DataProvider(name = "testInputCorrectDataForRegistration")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(6), RandomData.generateRandomEmail(), RandomStringUtils.randomAlphanumeric(10)}
        };
    }

    @Test(dataProvider = "testInputCorrectDataForRegistration")
    void testInputCorrectDataForRegistration(String name, String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForRegistration(name, email, password);
        Assert.assertFalse(loginPage.isTextElementInstructionExist(), "You entered the incorrect data");
    }
}
