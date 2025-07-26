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
        String projectName = RpConfig.get("rp.project");

        // Шаг 1: Создание запуска
        POSTlaunch post = new POSTlaunch();
        Response response = post.createLaunch(projectName);

        // Шаг 2: Проверка статус-кода
        assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Description("Positive")
    @Test
    public void updateLaunchTest() throws Exception {
        String projectName = RpConfig.get("rp.project");

        // Шаг 1: создаём запуск
        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        PutLaunchRequest updateBody = new PutLaunchRequest();
        updateBody.setDescription("Обновлено через API");

        // Шаг 3: отправляем PUT-запрос
        PUTlaunch put = new PUTlaunch();
        Response putResponse = put.updateLaunch(projectName, launchNumber, updateBody);

        // Шаг 4: проверяем статус-код и тело ответа
        assertThat(putResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void getLaunchTest() throws Exception {
        String projectName = RpConfig.get("rp.project");

        // Шаг 1: создаём запуск, чтобы его потом получить
        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        // Шаг 2: отправляем GET-запрос
        GETlaunch get = new GETlaunch();
        Response getResponse = get.getLaunch(projectName, launchNumber);

        // Шаг 3: проверяем статус-код
        assertThat(getResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Positive")
    @Test
    public void deleteLaunchTest() throws Exception {
        String projectName = RpConfig.get("rp.project");

        // Шаг 1: создаём запуск
        POSTlaunch post = new POSTlaunch();
        Response postResponse = post.createLaunch(projectName);

        ObjectMapper mapper = new ObjectMapper();
        CreateLaunchResponse launch = mapper.readValue(postResponse.asString(), CreateLaunchResponse.class);
        String launchNumber = String.valueOf(launch.getNumber());

        // Шаг 2: отправляем DELETE
        DELETElaunch delete = new DELETElaunch();
        Response deleteResponse = delete.deleteLaunch(projectName, launchNumber);

        // Шаг 3: проверяем статус-код
        assertThat(deleteResponse.getStatusCode()).isEqualTo(200);
    }

    @Description("Negativ")
    @Test
    public void getNonExistingLaunchTest() {
        String projectName = RpConfig.get("rp.project");
        String nonexistentLaunchNumber = "number 99";

        GETlaunch get = new GETlaunch();
        Response response = get.getLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Description("Negativ")
    @Test
    public void deleteNonExistingLaunchTest() {
        String projectName = RpConfig.get("rp.project");
        String nonexistentLaunchNumber = "99999999";

        DELETElaunch delete = new DELETElaunch();
        Response response = delete.deleteLaunch(projectName, nonexistentLaunchNumber);

        assertThat(response.getStatusCode()).isEqualTo(404);
    }
}