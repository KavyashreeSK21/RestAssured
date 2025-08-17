package org.kavya.HTTP_Method_Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostByUsingBDDApproach {

    String payload="{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    public void postBDD()
    {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().log().all()
                .post()
                .then().log().all()
                .statusCode(200);

    }
}
