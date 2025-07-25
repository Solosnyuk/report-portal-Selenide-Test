package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GETlaunch {

    public Response getLaunch(String projectName, String launchNumber) {
        String url = RpConfig.get("rp.endpoint") + "/api/v1/" + projectName + "/launch/" + launchNumber;

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.get("rp.api.key"))
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }
}
