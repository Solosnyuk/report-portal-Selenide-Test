package tests.api;

import api.RpConfig;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = RpConfig.getConfig().getEndpoint();
        RestAssured.authentication = RestAssured.oauth2(RpConfig.getConfig().getApiKey());
    }
}
