package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DELETElaunch {
    public Response deleteLaunch(String projectName, String launchId) {
        String url = RpConfig.get("rp.endpoint") + "/api/v1/" + projectName + "/launch/" + launchId;

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.get("rp.api.key"))
                .when()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }
}
