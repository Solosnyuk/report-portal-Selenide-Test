package stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import ui.page.LaunchesPage;
import ui.page.LaunchesPageLocators;
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

    @Given("открыта страница Launches")
    public void открыта_страница_launches() {
        LaunchesPage.clickOpenLaunchesPage();
    }

    @When("добавляет новый фильтр с именем {string} и текстом {string}")
    public void добавляет_новый_фильтр(String name, String text) {
        LaunchesPage.addNewFilter(name, text);
    }

    @When("он открывает страницу Launches")
    public void он_открывает_страницу_launches() {
        LaunchesPage.clickOpenLaunchesPage();
    }

    @When("пользователь удаляет этот фильтр")
    public void пользователь_удаляет_этот_фильтр() {
        LaunchesPage.clickButtonDeleteFilter();
    }

    @Then("фильтр {string} не отображается")
    public void фильтр_не_отображается(String name) {
        Assert.assertFalse(verifyElementVisibleByXPath(filterByNameAddXPathTemplate, name));
    }

    @Then("фильтр с именем {string} должен быть отображён")
    public void фильтр_должен_быть_отображён(String name) {
        Assert.assertTrue(verifyElementVisibleByXPath(filterByNameAddXPathTemplate, name));
    }
}