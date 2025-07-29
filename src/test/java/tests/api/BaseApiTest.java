package tests.api;

import api.RpConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = RpConfig.getKey("rp.endpoint");
        RestAssured.authentication = RestAssured.oauth2(RpConfig.getKey("rp.api.key"));
    }
}
