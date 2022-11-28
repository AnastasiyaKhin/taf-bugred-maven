package khinevich_anastasiya.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APIUserTest {
    @Test
    void testCreateNewUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/doregister";
        String name = "Andrei";
        String email = "Andrei@mail.com";
        String password = "123455";
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
        String email = "1234566@gmail.ru";

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
        String email = "1234566@gmail.ru";
        String hobby = "learning";
        String inn = "012345678901";
        String birthday = "01.05.2000";
        String date_start = "28.11.2022";

        String requestBody = String.format("{\"email\":\"%s\",\"hobby\":\"%s\",\"inn\":\"%s\",\"birthday\":\"%s\",\"date_start\":\"%s\"}", email, hobby, inn, birthday, date_start);
        given().header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }

    @Test
    void testDeleteUser() {
        String endPoint = "http://users.bugred.ru/tasks/rest/deleteuser";
        String email = "3333@gmail.ru";
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
    }
}

