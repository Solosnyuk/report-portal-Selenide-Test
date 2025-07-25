package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = RpConfig.get("rp.endpoint");
        RestAssured.authentication = RestAssured.oauth2(RpConfig.get("rp.api.key"));
    }
}
