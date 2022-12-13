package khinevich_anastasiya.ui.page;

import org.openqa.selenium.By;

public class UsersPage extends BasePage {
    public final String LABEL_LOGIN = "Вход";
    public final String LABEL_INSTRUCTION = "С помощью формы ниже,вы сможете авторизоваться на нашем ресурсе";
    public final String LABEL_INPUT_EMAIL = "Email";
    public final String LABEL_INPUT_PASSWORD = "Пароль";
    public final String BUTTON_LOGIN = "Авторизоваться";
    public final String LABEL_REGISTRATION = "Регистрация";
    public final String LABEL_REGISTRATION_NAME = "Имя";
    public final String LABEL_REGISTRATION_EMAIL = "Email";
    public final String LABEL_REGISTRATION_PASSWORD = "Пароль";
    public final String BUTTON_REGISTRATION = "Зарегистрироваться";
    private final By inputPage = By.xpath("//a[@href ='/user/login/index.html']");
    private final String inputBox = "//h2[contains(text(),'%s')]/ancestor::div[@class = 'col-md-6']//input[@name='%s']";
    private String elementInput = "//h2[contains(text(),'%s')]";
    private final By elementInstruction = By.xpath("//h2[contains(text(),'Вход')]/ancestor::div[@class = 'col-md-6']//p[@class = 'lead']");
    private String elementLabelForLogin = "//h2[contains(text(),'%s')]/ancestor::div[@class = 'col-md-6']//td[contains(text(),'%s')]";
    private String elementButton = "//h2[contains(text(),'%s')]/ancestor::div[@class = 'col-md-6']//input[@value='%s']";

    public UsersPage clickInputPageLink() {
        clickOnElement(inputPage);
        return this;
    }
    public String getTextElementLabelLogin() {
        By elementLogin = By.xpath(String.format(elementInput, "Вход"));
        return getText(elementLogin);
    }
    public String getTextElementLabelInstruction() {
        return getText(elementInstruction);
    }
    public String getTextElementLabelInputEmail() {
        By elementInputEmail = By.xpath(String.format(elementLabelForLogin, "Вход", "Email"));
        return getText(elementInputEmail);
    }
    public String getTextElementLabelInputPassword() {
        By elementInputPassword = By.xpath(String.format(elementLabelForLogin, "Вход", "Пароль"));
        return getText(elementInputPassword);
    }
    public String getTextElementLabelRegistration() {
        By elementRegistration = By.xpath(String.format(elementInput, "Регистрация"));
        return getText(elementRegistration);
    }
    public String getTextElementLabelRegName() {
        By elementRegName = By.xpath(String.format(elementLabelForLogin, "Регистрация", "Имя"));
        return getText(elementRegName);
    }
    public String getTextElementLabelRegEmail() {
        By elementRegEmail = By.xpath(String.format(elementLabelForLogin, "Регистрация", "Email"));
        return getText(elementRegEmail);
    }
    public String getTextElementLabelRegPassword() {
        By elementRegPassword = By.xpath(String.format(elementLabelForLogin, "Регистрация", "Пароль"));
        return getText(elementRegPassword);
    }
    public String getTextElementButtonLogin() {
        By elementButtonLogin = By.xpath(String.format(elementButton, "Вход", "Авторизоваться"));
        return driver.findElement(elementButtonLogin).getAccessibleName();
    }
    public String getTextElementButtonReg() {
        By elementButtonReg = By.xpath(String.format(elementButton, "Регистрация", "Зарегистрироваться"));
        return driver.findElement(elementButtonReg).getAccessibleName();
    }
    public UsersPage inputDataNameReg(String name) {
        By dataNameReg = By.xpath(String.format(inputBox, "Регистрация", "name"));
        driver.findElement(dataNameReg).sendKeys(name);
        return this;
    }
    public UsersPage inputDataEmailReg(String email) {
        By dataEmailReg = By.xpath(String.format(inputBox, "Регистрация", "email"));
        driver.findElement(dataEmailReg).sendKeys(email);
        return this;
    }
    public UsersPage inputDataPasswordReg(String password) {
        By dataPasswordReg = By.xpath(String.format(inputBox, "Регистрация", "password"));
        driver.findElement(dataPasswordReg).sendKeys(password);
        return this;
    }
    public UsersPage inputDataEmail(String email) {
        By dataEmail = By.xpath(String.format(inputBox, "Вход", "login"));
        driver.findElement(dataEmail).sendKeys(email);
        return this;
    }
    public UsersPage inputDataPassword(String password) {
        By dataPassword = By.xpath(String.format(inputBox, "Вход", "password"));
        driver.findElement(dataPassword).sendKeys(password);
        return this;
    }
    public UsersPage clickButtonLogIn() {
        clickOnElement(By.xpath(String.format(elementButton, "Вход", "Авторизоваться")));
        return this;
    }
    public UsersPage clickButtonRegistration() {
        clickOnElement(By.xpath(String.format(elementButton, "Регистрация", "Зарегистрироваться")));
        return this;
    }
    public boolean isTextElementInstructionExist() {
        if (driver.findElements(elementInstruction).size() > 0)
            return true;
        else
            return false;
    }
}
