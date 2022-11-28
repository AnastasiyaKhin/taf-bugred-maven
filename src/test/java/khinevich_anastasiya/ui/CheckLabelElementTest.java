package khinevich_anastasiya.ui;

import khinevich_anastasiya.ui.page.UsersPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckLabelElementTest extends BaseTest{
    UsersPage loginPage = new UsersPage();
    @Test
    void testCheckElements(){
        final String EXPECTED_LABEL_LOGIN = "Вход";
        final String EXPECTED_LABEL_INSTRUCTION = "С помощью формы ниже,вы сможете авторизоваться на нашем ресурсе";
        final String EXPECTED_LABEL_INPUT_EMAIL = "Email";
        final String EXPECTED_LABEL_INPUT_PASSWORD = "Пароль";
        final String EXPECTED_BUTTON_LOGIN = "Авторизоваться";
        final String EXPECTED_LABEL_REGISTRATION = "Регистрация";
        final String EXPECTED_LABEL_REGISTRATION_NAME = "Имя";
        final String EXPECTED_LABEL_REGISTRATION_EMAIL = "Email";
        final String EXPECTED_LABEL_REGISTRATION_PASSWORD = "Пароль";
        final String EXPECTED_BUTTON_REGISTRATION = "Зарегистрироваться";

        loginPage.clickInputPageLink();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(loginPage.getTextElementLabelLogin(),EXPECTED_LABEL_LOGIN);
        softAssert.assertEquals(loginPage.getTextElementLabelInstruction(),EXPECTED_LABEL_INSTRUCTION);
        softAssert.assertEquals(loginPage.getTextElementLabelInputEmail(),EXPECTED_LABEL_INPUT_EMAIL);
        softAssert.assertEquals(loginPage.getTextElementLabelInputPassword(),EXPECTED_LABEL_INPUT_PASSWORD);
        softAssert.assertEquals(loginPage.getTextElementButtonLogin(),EXPECTED_BUTTON_LOGIN);
        softAssert.assertEquals(loginPage.getTextElementLabelRegistration(),EXPECTED_LABEL_REGISTRATION);
        softAssert.assertEquals(loginPage.getTextElementLabelRegName(),EXPECTED_LABEL_REGISTRATION_NAME);
        softAssert.assertEquals(loginPage.getTextElementLabelRegEmail(),EXPECTED_LABEL_REGISTRATION_EMAIL);
        softAssert.assertEquals(loginPage.getTextElementLabelRegPassword(),EXPECTED_LABEL_REGISTRATION_PASSWORD);
        softAssert.assertEquals(loginPage.getTextElementButtonReg(),EXPECTED_BUTTON_REGISTRATION);
        softAssert.assertAll();
    }
}
