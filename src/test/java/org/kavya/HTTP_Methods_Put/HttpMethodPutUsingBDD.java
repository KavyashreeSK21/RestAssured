package org.kavya.HTTP_Methods_Put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpMethodPutUsingBDD {

    //url-https://restful-booker.herokuapp.com/booking/4634
    //body
    //booking id-4634
    //cookie

    RequestSpecification rs;
    Response r;
    ValidatableResponse vs;
    String bookingid="2151";
   String token="415c94428b339ad";

    @Test
    public void patchUsingBDD()
    {

        String payload="{\n" +
                "    \"firstname\" : \"Avyukth\",\n" +
                "    \"lastname\" : \"ak\",\n" +
                "    \"totalprice\" : 100000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        r=rs.when().log().all().put();

        vs=r.then().log().all();
        vs.statusCode(200);

    }
}
