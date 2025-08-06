package stepdefs;

import io.cucumber.java.en.*;
import ui.page.LaunchesPage;
import ui.page.LoginPage;
import api.RpConfig;

import static tests.ui.BaseUiTest.verifyElementVisibleByXPath;
import static ui.page.LaunchesPageLocators.filterByNameAddXPathTemplate;

public class LaunchesSteps {

    String filterName;
    String filterText;

    @Given("пользователь авторизован")
    public void пользователь_авторизован() {
        LoginPage.login(RpConfig.getConfig().getLogin(), RpConfig.getConfig().getPassword());
    }

    @When("он открывает страницу Launches")
    public void он_открывает_страницу_launches() {
        LaunchesPage.clickOpenLaunchesPage();
    }

    @When("добавляет новый фильтр с именем {string} и текстом {string}")
    public void добавляет_новый_фильтр(String name, String text) {
        filterName = name;
        filterText = text;
        LaunchesPage.addNewFilter(name, text);
    }

    @Then("фильтр с именем {string} должен быть отображён")
    public void фильтр_должен_быть_отображён(String name) {
        assert verifyElementVisibleByXPath(filterByNameAddXPathTemplate, name);
    }
}
