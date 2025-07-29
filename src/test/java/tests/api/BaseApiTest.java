package tests.api;

import api.RpConfig;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = RpConfig.getConfig().getEndpoint();
        RestAssured.authentication = RestAssured.oauth2(RpConfig.getConfig().getApiKey());
    }
}
