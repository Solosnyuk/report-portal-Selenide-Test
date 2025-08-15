package tests.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import ui.page.LaunchesPage;
import ui.page.LaunchesPageLocators;
import ui.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.RpConfig;

import static utils.GenerateName.generateName;

@Epic("UI Tests")
public class LaunchesTest extends BaseUiTest {
    private static final Logger logger = LogManager.getLogger(LaunchesTest.class);

    @Story("Add new filter")
    @Test(groups = "UI", description = "UI Test")
    public void testAddNewFilter() {
        logger.info("=== testAddNewFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Добавление нового фильтра '{}'", filterName);
        new LoginPage().login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        new LaunchesPage().clickOpenLaunchesPage();
        new LaunchesPage().addNewFilter(filterName, textFilter);

        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, filterName));

    }

    @Story("Clone filter")
    @Test(groups = "UI", description = "UI Test")
    public void testCloneFilter() {
        logger.info("=== testCloneFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Клонирование фильтра '{}'", filterName);
        new LoginPage().login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        new LaunchesPage().clickOpenLaunchesPage();
        new LaunchesPage().addNewFilter(filterName, textFilter);

        new LaunchesPage().clickCloneFilter();
        new LaunchesPage().clickButtonSaveFilter();
        new LaunchesPage().clickButtonAddFilterSave();

        String cloneName = "Copy " + filterName;
        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, cloneName));
    }

    @Story("Delete filter")
    @Test(groups = "UI", description = "UI Test")
    public void testDeleteFilter() {
        logger.info("=== testDeleteFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Удаление фильтра '{}'", filterName);
        new LoginPage().login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        new LaunchesPage().clickOpenLaunchesPage();
        new LaunchesPage().addNewFilter(filterName, textFilter);
        new LaunchesPage().clickButtonDeleteFilter();

        Assert.assertFalse(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, filterName));
    }

    @Story("Edit filter")
    @Test(groups = "UI", description = "UI Test")
    public void testEditFilter() {
        logger.info("=== testEditFilter START ===");

        String filterName = generateName();
        String textFilter = generateName();
        String newName = generateName();

        logger.info("Редактирование фильтра '{}' → '{}'", filterName, newName);
        new LoginPage().login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        new LaunchesPage().clickOpenLaunchesPage();
        new LaunchesPage().addNewFilter(filterName, textFilter);
        new LaunchesPage().editNameFilter(newName);

        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, newName));
    }

    @Step("{step}")
    private void logStep(String step) {
        logger.info("[STEP] {}", step);
    }
}
