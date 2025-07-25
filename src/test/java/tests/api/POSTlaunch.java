package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tests.api.pojos.CreateLaunchRequest;

import static io.restassured.RestAssured.given;

public class POSTlaunch {
    public Response createLaunch(String projectName) {
        String url = RpConfig.get("rp.endpoint") + "/api/v1/" + projectName + "/launch";

        CreateLaunchRequest requestBody = CreateLaunchRequest.defaultLaunch("Mobile tests CI run");

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.get("rp.api.key"))
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
}
