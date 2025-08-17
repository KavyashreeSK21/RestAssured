package org.kavya.HTTP_Method_Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpPatchUsingNonBDD {

    //url
    //body
    //booking id
    //

    RequestSpecification rs;
    Response r;
    ValidatableResponse vs;
    String bookingid="2151";
    String token="88a5f488c8f7ced";

    @Test
    public void patchUsingBDD()
    {

        String payload="{\n" +
                "    \"firstname\" : \"Test\",\n" +
                "    \"lastname\" : \"Java\"\n" +
                "}";

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        r=rs.when().log().all().patch();

        vs=r.then().log().all();
        vs.statusCode(200);

    }
}
