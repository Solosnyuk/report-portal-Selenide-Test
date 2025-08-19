package tests.api;

import api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import api.pojos.CreateLaunchResponse;
import api.pojos.PutLaunchRequest;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("API Tests")
public class CrudTest extends BaseApiTest {

    @Story("Create Launch")
    @Test(groups = "API", description = "API Test")
    public void createLaunchTest() throws Exception {
        logger.info("[ТЕСТ] createLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response response = post.createLaunch();

        assertThat(response.getStatusCode())
                .as("Response Body: %s", response.getBody().asPrettyString())
                .isEqualTo(231);
    }

    @Story("Update Launch")
    @Test(groups = "API", description = "API Test")
    public void updateLaunchTest() throws Exception {
        logger.info("[ТЕСТ] updateLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch();

        Uthils.waitForStatusCode(() -> postResponse.getStatusCode(), 201);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        PutLaunchRequest updateBody = new PutLaunchRequest();
        updateBody.setDescription("Обновлено через API");

        PutLaunch put = new PutLaunch();
        Response putResponse = put.updateLaunch(launchNumber, updateBody);

        assertThat(putResponse.getStatusCode())
                .as("Response Body: %s", putResponse.getBody().asPrettyString())
                .isEqualTo(200);
    }

    @Story("Get Launch")
    @Test(groups = "API", description = "API Test")
    public void getLaunchTest() throws Exception {
        logger.info("[ТЕСТ] getLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch();

        Uthils.waitForStatusCode(() -> postResponse.getStatusCode(), 201);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        GetLaunch get = new GetLaunch();
        Response getResponse = get.getLaunch(launchNumber);

        assertThat(getResponse.getStatusCode())
                .as("Response Body: %s", getResponse.getBody().asPrettyString())
                .isEqualTo(200);
    }

    @Story("Get Non-Existing Launch")
    @Test(groups = "API", description = "API Test")
    public void getNonExistingLaunchTest() {
        logger.info("[ТЕСТ] getNonExistingLaunchTest запущен");
        String nonexistentLaunchNumber = "number 99";

        GetLaunch get = new GetLaunch();
        Response response = get.getLaunch(nonexistentLaunchNumber);

        assertThat(response.getStatusCode())
                .as("Response Body: %s", response.getBody().asPrettyString())
                .isEqualTo(404);
    }

    @Story("Delete Non-Existing Launch")
    @Test(groups = "API", description = "API Test")
    public void deleteNonExistingLaunchTest() {
        logger.info("[ТЕСТ] deleteNonExistingLaunchTest запущен");
        int nonexistentLaunchNumber = 99999999;

        DeleteLaunch delete = new DeleteLaunch();
        Response response = delete.deleteLaunch(nonexistentLaunchNumber);

        assertThat(response.getStatusCode())
                .as("Response Body: %s", response.getBody().asPrettyString())
                .isEqualTo(404);
    }
}
