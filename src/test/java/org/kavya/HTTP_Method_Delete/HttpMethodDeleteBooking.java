package org.kavya.HTTP_Method_Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpMethodDeleteBooking {

    //url
    //bookingid
    //cookie

    RequestSpecification rs;
    Response r;
    ValidatableResponse vs;
    String bookingid="1423";
    String token="fd57a2ac0cf4442";

    @Test
    public void deleteUsingBDD()
    {


        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);


        r=rs.when().log().all().delete();

        vs=r.then().log().all();
        vs.statusCode(201);

    }
}
