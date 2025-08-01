package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteLaunch {
    public Response deleteLaunch(Integer launchId) {
        String url = RpConfig.getConfig().getEndpoint() + "/api/v1/"
                + RpConfig.getConfig().getProjectName() + "/launch/" + launchId;

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getConfig().getApiKey())
                .when()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }
}
