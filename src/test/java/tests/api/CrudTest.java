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
        System.out.println("[ТЕСТ] createLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");

        PostLaunch post = new PostLaunch();
        Response response = post.createLaunch(projectName);

        assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Description("Positive")
    @Test
    public void updateLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] updateLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        PutLaunchRequest updateBody = new PutLaunchRequest();
        updateBody.setDescription("Обновлено через API");

        PutLaunch put = new PutLaunch();
        Response putResponse = put.updateLaunch(projectName, launchNumber, updateBody);

        assertThat(putResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void getLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] getLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        GetLaunch get = new GetLaunch();
        Response getResponse = get.getLaunch(projectName, launchNumber);

        assertThat(getResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void deleteLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] deleteLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");

        PostLaunch post = new PostLaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        Integer launchNumber = Math.toIntExact(launch.getNumber());

        DeleteLaunch delete = new DeleteLaunch();
        Response deleteResponse = delete.deleteLaunch(projectName, launchNumber);

        assertThat(deleteResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Negative")
    @Test
    public void getNonExistingLaunchTest() {
        System.out.println("[ТЕСТ] getNonExistingLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");
        String nonexistentLaunchNumber = "number 99";

        GetLaunch get = new GetLaunch();
        Response response = get.getLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Description("Negative")
    @Test
    public void deleteNonExistingLaunchTest() {
        System.out.println("[ТЕСТ] deleteNonExistingLaunchTest запущен");
        String projectName = RpConfig.getKey("rp.project");
        int nonexistentLaunchNumber = 99999999;

        DeleteLaunch delete = new DeleteLaunch();
        Response response = delete.deleteLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }
}