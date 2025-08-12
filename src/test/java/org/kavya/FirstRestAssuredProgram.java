package org.kavya;

import io.restassured.RestAssured;

public class FirstRestAssuredProgram {


    public static void main(String[] args) {

        //https://restful-booker.herokuapp.com/ping

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .when().log().all().get()
                .then().log().all()
                .statusCode(201);
    }
}
