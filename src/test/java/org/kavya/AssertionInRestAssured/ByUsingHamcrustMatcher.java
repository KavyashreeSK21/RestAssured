package org.kavya.AssertionInRestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class ByUsingHamcrustMatcher {

    //In rest assured we can achive assertion by using 3 ways
    //1. By using Hamcrust Matchers
    //2.By using Testng
    //3.assertJ

    //what all we are validating
    //1.Response status
    //2.Response body
    //3.Response time
    //4.cookies
    //5.Header
    //6.json schema

    @Test
    public void createBooking()
    {
        //url
        //payload
        //header

        String payload="{\n" +
                "    \"firstname\" : \"pavan\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        RequestSpecification rs;
        Response r;
        ValidatableResponse vr;

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.body(payload);
        rs.contentType(ContentType.JSON);

        r=rs.when().log().all().post();

        vr=r.then().log().all();
        vr.statusCode(200);

        //booking id should not be null
        //firstname should be equal to pavan

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("pavan"));
        vr.body("booking.bookingdates.checkin",Matchers.equalTo("2018-01-01"));

    }
}
