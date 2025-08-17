package org.kavya.HTTP_Method_Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HttpPostRequestNonBDD {

    //url-https://restful-booker.herokuapp.com/auth
    //body-{
    //    "username" : "admin",
    //    "password" : "password123"
    //}
    //header-Content-Type : application/json

    @Test
    public void postMethodNonBDD()
    {
       String payload="{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";

        RequestSpecification rs;
        Response r;
        ValidatableResponse vs;

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.body(payload);
        rs.contentType(ContentType.JSON);

        r=rs.when().log().all().post();

        vs=r.then().log().all();
        vs.statusCode(200);

    }
}
