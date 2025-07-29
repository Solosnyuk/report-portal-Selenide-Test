package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.pojos.PutLaunchRequest;

import static io.restassured.RestAssured.given;

public class PutLaunch {
    public Response updateLaunch(String projectName, String launchId, PutLaunchRequest requestBody) {
        String url = RpConfig.getKey("rp.endpoint") +
                "/api/v1/" + projectName +
                "/launch/" + launchId + "/update";

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getKey("rp.api.key"))
                .body(requestBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }
}
