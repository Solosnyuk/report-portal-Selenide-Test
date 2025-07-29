package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetLaunch {

    public Response getLaunch(String projectName, String launchNumber) {
        String url = RpConfig.getConfig().getEndpoint() + "/api/v1/"
                + projectName + "/launch/" + launchNumber;

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getConfig().getApiKey())
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }
}
