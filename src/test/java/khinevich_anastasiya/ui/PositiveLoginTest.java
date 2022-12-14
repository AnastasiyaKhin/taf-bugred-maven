package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveLoginTest extends BaseTest{
    UsersPage userPage = new UsersPage();

    @DataProvider(name = "testInputCorrectDataForLogIn")
    public Object[][] dataProvInputCorrectDataForLogIn(){
        return new Object[][]{
                {"1234566@gmail.ru","123456"}
        };
    }
    @Test(dataProvider="testInputCorrectDataForLogIn")
    void testInputCorrectDataForLogIn(String email, String password){
        Steps steps = new Steps();
        steps.inputDataForLogIn(email,password);
        Assert.assertFalse(userPage.isTextElementInstructionExist(),"You entered the incorrect data");
    }
}
