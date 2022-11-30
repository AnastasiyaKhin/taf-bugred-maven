package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import khinevich_anastasiya.ui.util.RandomData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeRegistrationTest extends BaseTest {
    UsersPage userPage = new UsersPage();

    @DataProvider(name = "testInputIncorrectDataForRegistration")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {"", "", ""},
                {"",RandomData.generateRandomEmail(),RandomData.generateRandomPassword()},
                {RandomData.generateRandomName(),"",RandomData.generateRandomPassword()},
                {RandomData.generateRandomName(),RandomData.generateRandomEmail(),""},
                {RandomData.generateRandomName(),RandomData.generateRandomName(),RandomData.generateRandomName()},
                {RandomData.generateRandomPassword(),RandomData.generateRandomPassword(),RandomData.generateRandomPassword()},
                {"^@&^#()!@#$%^&*()_+", "^@&^#()!@#$%^&*()_+", "^@&^#()!@#$%^&*()_+"},
                {RandomData.generateRandomEmail(),RandomData.generateRandomEmail(),RandomData.generateRandomEmail()}
        };
    }

    @Test(dataProvider = "testInputIncorrectDataForRegistration")
    void testInputIncorrectDataForRegistration(String name, String email, String password) {
        Steps steps = new Steps();
        steps.inputDataForRegistration(name, email, password);
        Assert.assertTrue(userPage.isTextElementInstructionExist(), "You entered the correct data and registration cancelled");
    }
}

