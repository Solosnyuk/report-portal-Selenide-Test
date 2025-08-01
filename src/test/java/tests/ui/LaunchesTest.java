package tests.ui;

import ui.page.LaunchesPage;
import ui.page.LaunchesPageLocators;
import ui.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.RpConfig;

import static utils.GenerateName.generateName;

public class LaunchesTest extends BaseUiTest {
    private static final Logger logger = LogManager.getLogger(LaunchesTest.class);

    @Test
    public void testAddNewFilter() {
        logger.info("=== testAddNewFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Добавление нового фильтра '{}'", filterName);
        LoginPage.login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);

        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, filterName));

    }

    @Test
    public void testCloneFilter() {
        logger.info("=== testCloneFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Клонирование фильтра '{}'", filterName);
        LoginPage.login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.clickCloneFilter();
        LaunchesPage.clickButtonSaveFilter();
        LaunchesPage.clickButtonAddFilterSave();

        String cloneName = "Copy " + filterName;
        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, cloneName));
    }

    @Test
    public void testDeleteFilter() {
        logger.info("=== testDeleteFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Удаление фильтра '{}'", filterName);
        LoginPage.login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.clickButtonDeleteFilter();

        Assert.assertFalse(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, filterName));
    }

    @Test
    public static void testEditFilter() {
        logger.info("=== testEditFilter START ===");

        String filterName = generateName();
        String textFilter = generateName();
        String newName = generateName();

        logger.info("Редактирование фильтра '{}' → '{}'", filterName, newName);
        LoginPage.login(RpConfig.getConfig().getLogin(),
                RpConfig.getConfig().getPassword());
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.editNameFilter(newName);

        Assert.assertTrue(verifyElementVisibleByXPath(
                LaunchesPageLocators.filterByNameAddXPathTemplate, newName));
    }
}
