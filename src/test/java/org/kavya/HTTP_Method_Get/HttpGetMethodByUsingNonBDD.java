package org.kavya.HTTP_Method_Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpGetMethodByUsingNonBDD {


    @Test
    public void getByUsingNonBDDStyle()
    {
        //url-https://restful-booker.herokuapp.com/booking/3408

        RequestSpecification rs;
        Response r;
        ValidatableResponse vr;
        String bookingId="1630";

        //part1- pre request, url
        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking/"+bookingId);

        //part2-maling request
        r=rs.when().log().all().get();

        //part-3- validation
        vr=r.then().log().all();
        vr.statusCode(200);


    }
}
