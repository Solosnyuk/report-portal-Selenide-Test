package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import tests.api.pojos.PutLaunchRequest;

import static io.restassured.RestAssured.given;

public class PUTlaunch {
    public Response updateLaunch(String projectName, String launchId, PutLaunchRequest requestBody) {
        String url = RpConfig.get("rp.endpoint") +
                "/api/v1/" + projectName +
                "/launch/" + launchId + "/update";

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.get("rp.api.key"))
                .body(requestBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }
}
