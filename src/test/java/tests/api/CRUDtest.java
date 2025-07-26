package tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import tests.api.pojos.CreateLaunchResponse;
import tests.api.pojos.PutLaunchRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class CRUDtest extends BaseApiTest {

    @Description("Positive")
    @Test
    public void createLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] createLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");

        POSTlaunch post = new POSTlaunch();
        Response response = post.createLaunch(projectName);

        assertThat(response.getStatusCode()).isEqualTo(201);
        System.out.println("[ТЕСТ] createLaunchTest успешно завершён\n");
    }

    @Description("Positive")
    @Test
    public void updateLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] updateLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");

        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        PutLaunchRequest updateBody = new PutLaunchRequest();
        updateBody.setDescription("Обновлено через API");

        PUTlaunch put = new PUTlaunch();
        Response putResponse = put.updateLaunch(projectName, launchNumber, updateBody);

        assertThat(putResponse.getStatusCode()).isEqualTo(200);
        System.out.println("[ТЕСТ] updateLaunchTest успешно завершён\n");
    }

    @Description("Positive")
    @Test
    public void getLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] getLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");

        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        GETlaunch get = new GETlaunch();
        Response getResponse = get.getLaunch(projectName, launchNumber);

        assertThat(getResponse.getStatusCode()).isEqualTo(200);
        System.out.println("[ТЕСТ] getLaunchTest успешно завершён\n");
    }

    @Description("Positive")
    @Test
    public void deleteLaunchTest() throws Exception {
        System.out.println("[ТЕСТ] deleteLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");

        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        Integer launchNumber = Math.toIntExact(launch.getNumber());

        DELETElaunch delete = new DELETElaunch();
        Response deleteResponse = delete.deleteLaunch(projectName, launchNumber);

        assertThat(deleteResponse.getStatusCode()).isEqualTo(200);
        System.out.println("[ТЕСТ] deleteLaunchTest успешно завершён\n");
    }

    @Description("Negative")
    @Test
    public void getNonExistingLaunchTest() {
        System.out.println("[ТЕСТ] getNonExistingLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");
        String nonexistentLaunchNumber = "number 99";

        GETlaunch get = new GETlaunch();
        Response response = get.getLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
        System.out.println("[ТЕСТ] getNonExistingLaunchTest успешно завершён\n");
    }

    @Description("Negative")
    @Test
    public void deleteNonExistingLaunchTest() {
        System.out.println("[ТЕСТ] deleteNonExistingLaunchTest запущен");
        String projectName = RpConfig.get("rp.project");
        int nonexistentLaunchNumber = 99999999;

        DELETElaunch delete = new DELETElaunch();
        Response response = delete.deleteLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
        System.out.println("[ТЕСТ] deleteNonExistingLaunchTest успешно завершён\n");
    }
}