package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetLaunch {

    public Response getLaunch(String projectName, String launchNumber) {
        String url = RpConfig.getKey("rp.endpoint") + "/api/v1/" + projectName + "/launch/" + launchNumber;

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + RpConfig.getKey("rp.api.key"))
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }
}
