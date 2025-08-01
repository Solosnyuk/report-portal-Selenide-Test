package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.pojos.PutLaunchRequest;

public class PutLaunch {
    public Response updateLaunch(String launchId, PutLaunchRequest requestBody) {
        String url = RpConfig.getConfig().getEndpoint() + "/api/v1/"
                + RpConfig.getConfig().getProjectName() + "/launch/" + launchId + "/update";

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getConfig().getApiKey())
                .body(requestBody)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }
}
