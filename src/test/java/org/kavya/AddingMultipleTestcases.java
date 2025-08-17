package org.kavya;

import io.restassured.RestAssured;

import java.util.Scanner;

public class AddingMultipleTestcases {

    //without using testng

    //https://zippopotam.us/in/560070
    public static void main(String[] args) {

        String pincode="560070";

        RestAssured.given()
                .baseUri("https://zippopotam.us/")
                .basePath("in/"+pincode)
                .when().log().all()
                .get()
                .then()
                .log().all()
                .statusCode(200);


        pincode = "@";

        RestAssured.given().baseUri("https://zippopotam.us/")
                .baseUri("in/"+pincode)
                .when().log().all()
                .then().statusCode(200);


        pincode = "";

        RestAssured.given().baseUri("https://zippopotam.us/")
                .baseUri("in/"+pincode)
                .when().log().all()
                .then().statusCode(200);




    }







}
