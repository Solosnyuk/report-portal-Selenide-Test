package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.pojos.CreateLaunchRequest;

import static io.restassured.RestAssured.given;

public class PostLaunch {
    public Response createLaunch(String projectName) {
        String url = RpConfig.getKey("rp.endpoint") + "/api/v1/" + projectName + "/launch";

        CreateLaunchRequest requestBody = CreateLaunchRequest.defaultLaunch("Mobile tests CI run");

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getKey("rp.api.key"))
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
}
