package khinevich_anastasiya.ui.steps;

import khinevich_anastasiya.ui.page.UsersPage;

public class Steps {
    private UsersPage loginPage;

    public Steps inputDataForLogIn(String email, String password) {
        loginPage = new UsersPage();
        loginPage.clickInputPageLink()
                .inputDataEmail(email)
                .inputDataPassword(password)
                .clickButtonLogIn();
        return this;
    }

    public Steps inputDataForRegistration(String name, String email, String password) {
        loginPage = new UsersPage();
        loginPage.clickInputPageLink()
                .inputDataNameReg(name)
                .inputDataEmailReg(email)
                .inputDataPasswordReg(password)
                .clickButtonRegistration();
        return this;
    }
}
