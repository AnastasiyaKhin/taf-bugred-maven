package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import khinevich_anastasiya.ui.steps.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckLabelElementTest extends BaseTest{
    UsersPage usersPage = new UsersPage();
    @Test
    void testCheckElements(){

        usersPage.clickInputPageLink();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(usersPage.getTextElementLabelLogin(),usersPage.LABEL_LOGIN);
        softAssert.assertEquals(usersPage.getTextElementLabelInstruction(),usersPage.LABEL_INSTRUCTION);
        softAssert.assertEquals(usersPage.getTextElementLabelInputEmail(),usersPage.LABEL_INPUT_EMAIL);
        softAssert.assertEquals(usersPage.getTextElementLabelInputPassword(),usersPage.LABEL_INPUT_PASSWORD);
        softAssert.assertEquals(usersPage.getTextElementButtonLogin(),usersPage.BUTTON_LOGIN);
        softAssert.assertEquals(usersPage.getTextElementLabelRegistration(),usersPage.LABEL_REGISTRATION);
        softAssert.assertEquals(usersPage.getTextElementLabelRegName(),usersPage.LABEL_REGISTRATION_NAME);
        softAssert.assertEquals(usersPage.getTextElementLabelRegEmail(),usersPage.LABEL_REGISTRATION_EMAIL);
        softAssert.assertEquals(usersPage.getTextElementLabelRegPassword(),usersPage.LABEL_REGISTRATION_PASSWORD);
        softAssert.assertEquals(usersPage.getTextElementButtonReg(),usersPage.BUTTON_REGISTRATION);
        softAssert.assertAll();
    }
}
