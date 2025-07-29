package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.pojos.CreateLaunchRequest;

public class PostLaunch {
    public Response createLaunch(String projectName) {
        String url = RpConfig.getConfig().getEndpoint() + "/api/v1/"
                + projectName + "/launch";

        CreateLaunchRequest requestBody = CreateLaunchRequest.defaultLaunch("Mobile tests CI run");

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getConfig().getApiKey())
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
}
