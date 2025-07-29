package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteLaunch {
    public Response deleteLaunch(String projectName, Integer launchId) {
        String url = RpConfig.getKey("rp.endpoint") + "/api/v1/" + projectName + "/launch/" + launchId;

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getKey("rp.api.key"))
                .when()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }
}
