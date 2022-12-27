package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testase.TestBase;
import com.gorest.testase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;


    @Test
    public void verifyUserCreatedSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Sid");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization", "Bearer 3fd5c5d69049fe0983c50eccc57a83d284bd9dbcff3d769acd739294f73b86bb")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public void verifyUsergetSuccessfully() {


        Response response = given()
                .header("Authorization", "Bearer 3fd5c5d69049fe0983c50eccc57a83d284bd9dbcff3d769acd739294f73b86bb")
                .header("Connection", "keep-alive")
                .when()

                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();

        userPojo.setName("Sid");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("Inactive");
        Response response = given()
                .header("Authorization", "Bearer 3fd5c5d69049fe0983c50eccc57a83d284bd9dbcff3d769acd739294f73b86bb")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .put("/users/11757");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void VerifyUserDeleteSuccessfully() {
        Response response = given()
                .header("Authorization", "Bearer 3fd5c5d69049fe0983c50eccc57a83d284bd9dbcff3d769acd739294f73b86bb")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/11757");
        response.prettyPrint();
        response.then().statusCode(204);


    }
}


