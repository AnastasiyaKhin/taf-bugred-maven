package khinevich_anastasiya.api;

import khinevich_anastasiya.ui.util.RandomData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APIUserTest {
    @Test
    void testCreateNewUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = RandomData.generateRandomName();
        String email = RandomData.generateRandomEmail();
        String password = RandomData.generateRandomPassword();
        String requestBody = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}", name, email, password);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
        .when()
                .log().all()
                .post(endPoint)
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    void testGetUserInfo() {
        String endPoint = "http://users.bugred.ru/tasks/rest/getuser";
        String email = RandomData.generateRandomEmail();
        String requestBody = String.format("{\"email\":\"%s\"}", email);

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
        .when()
                .log().all()
                .get(endPoint)
        .then()
                .log().all()
                .statusCode(200)
                .body("email", is(email));

    }

    @Test
    void testPatchUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/fullupdateuser";
        String email = RandomData.generateRandomEmail();
        String hobby = "learning";
        String inn = RandomData.generateRandomIIN();
        String birthday = RandomData.generateRandomDate();
        String date_start = RandomData.generateRandomDate();

        String requestBody = String.format("{\"email\":\"%s\",\"hobby\":\"%s\",\"inn\":\"%s\",\"birthday\":\"%s\",\"date_start\":\"%s\"}", email, hobby, inn, birthday, date_start);
        given().header("Content-type", "application/json")
                .and()
                .body(requestBody)
        .when()
                .log().all()
                .patch(endPoint)
        .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    void testDeleteUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/deleteuser";
        String email = RandomData.generateRandomEmail();
        String requestBody = String.format("{\"email\":\"%s\"}", email);
        given().header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .log().all()
                .delete(endPoint)
                .then()
                .log().all()
                .extract().response();
        Assert.fail("Test is not completed");
    }
}

