package org.kavya.AssertionInRestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AssertionByUsingAllTheThreeways {

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

        //way 1 - By using HamcrastMatchers
        //Direct way - not recommended

        vr.body("bookingid",Matchers.notNullValue());
        vr.body("booking.lastname",Matchers.equalTo("Brown"));


        //way2 - By using Testng
        //here we want to extract the response value and store it in a variable - this can be used for both testng and assertJ

        //Extraction
        //type1
        Integer bookingid=r.then().extract().path("bookingid");
        String firstName=r.then().extract().path("booking.firstname");
        Integer totalPrice=r.then().extract().path("booking.totalprice");

        //type2
        JsonPath jp=new JsonPath(r.asString());
        String bookingId1=jp.getString("bookingid");

        Assert.assertNotNull("bookingid");
        Assert.assertEquals(firstName,"pavan");
        Assert.assertEquals(totalPrice,111);

        //way3- by using assertJ - here we should add dependency in pom.xml file
        assertThat(bookingid).isNotNull().isNotNegative();
        assertThat(firstName).isNotNull().isNotEmpty().isEqualTo("pavan");




    }
}
