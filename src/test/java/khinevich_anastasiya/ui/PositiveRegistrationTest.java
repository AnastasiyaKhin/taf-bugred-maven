package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import khinevich_anastasiya.ui.util.RandomData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveRegistrationTest extends BaseTest {
    UsersPage userPage = new UsersPage();

    @DataProvider(name = "testInputCorrectDataForRegistration")
    public Object[][] dataProvInputCorrectDataForRegistration() {
        return new Object[][]{
                {RandomData.generateRandomName(), RandomData.generateRandomEmail(), RandomData.generateRandomPassword()}
        };
    }

    @Test(dataProvider = "testInputCorrectDataForRegistration")
    void testInputCorrectDataForRegistration(String name, String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForRegistration(name, email, password);
        Assert.assertFalse(userPage.isTextElementInstructionExist(), "You entered the incorrect data");
    }
}
