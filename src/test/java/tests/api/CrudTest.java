package tests.api;

import api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import api.pojos.CreateLaunchResponse;
import api.pojos.PutLaunchRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class CrudTest extends BaseApiTest {

    @Description("Positive")
    @Test
    public void createLaunchTest() throws Exception {
        logger.info("[ТЕСТ] createLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response response = post.createLaunch();

        assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Description("Positive")
    @Test
    public void updateLaunchTest() throws Exception {
        logger.info("[ТЕСТ] updateLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch();

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        PutLaunchRequest updateBody = new PutLaunchRequest();
        updateBody.setDescription("Обновлено через API");

        PutLaunch put = new PutLaunch();
        Response putResponse = put.updateLaunch(launchNumber, updateBody);

        assertThat(putResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void getLaunchTest() throws Exception {
        logger.info("[ТЕСТ] getLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch();

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        GetLaunch get = new GetLaunch();
        Response getResponse = get.getLaunch(launchNumber);

        assertThat(getResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void deleteLaunchTest() throws Exception {
        logger.info("[ТЕСТ] deleteLaunchTest запущен");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch();

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        Integer launchNumber = Math.toIntExact(launch.getNumber());

        Thread.sleep(400);
        DeleteLaunch delete = new DeleteLaunch();
        Response deleteResponse = delete.deleteLaunch(launchNumber);

        assertThat(deleteResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Negative")
    @Test
    public void deleteNonExistingLaunchTest() {
        logger.info("[ТЕСТ] deleteNonExistingLaunchTest запущен");
        int nonexistentLaunchNumber = 99999999;

        DeleteLaunch delete = new DeleteLaunch();
        Response response = delete.deleteLaunch(nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }
}