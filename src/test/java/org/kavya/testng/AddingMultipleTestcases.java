package org.kavya.testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class AddingMultipleTestcases {

    String pincode;
    @Test
    public void testcase1()
    {
        pincode="560070";
        RestAssured.given()
                .baseUri("https://zippopotam.us/")
                .basePath("in/"+ pincode)
                .when().log().all().get()
                .then().statusCode(200);
    }


    @Test
    public void testcase2()
    {
        pincode="@";
        RestAssured.given()
                .baseUri("https://zippopotam.us/")
                .basePath("in/"+pincode)
                .when().log().all().get()
                .then().statusCode(200);
    }

    @Test
    public void testcase3()
    {
        pincode=" ";
        RestAssured.given()
                .baseUri("https://zippopotam.us/")
                .basePath("in/"+pincode)
                .when().log().all().get()
                .then().statusCode(200);
    }
}
