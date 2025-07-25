package tests.ui;

import UIpage.LaunchesPage;
import UIpage.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchesTest extends BaseUiTest {
    private static final Logger logger = LogManager.getLogger(LaunchesTest.class);

    static String login = "default";
    static String password = "1q2w3e";

    @Test
    public void testAddNewFilter() {
        logger.info("=== testAddNewFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Добавление нового фильтра '{}'", filterName);
        LoginPage.login(login, password);
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);

        Assert.assertTrue(verifyElementVisibleByXPath(
                "//span[text()='%s']", filterName));
        logger.info("Фильтр '{}' успешно добавлен", filterName);
        logger.info("=== testAddNewFilter END ===");
    }

    @Test
    public void testCloneFilter() {
        logger.info("=== testCloneFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Клонирование фильтра '{}'", filterName);
        LoginPage.login(login, password);
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.clickCloneFilter();
        LaunchesPage.clickButtonSaveFilter();
        LaunchesPage.clickButtonAddFilterSave();

        String cloneName = "Copy " + filterName;
        Assert.assertTrue(verifyElementVisibleByXPath(
                "//span[text()='%s']", cloneName));
        logger.info("Клон фильтра '{}' успешно отображается.", cloneName);
        logger.info("=== testCloneFilter END ===");
    }

    @Test
    public void testDeleteFilter() {
        logger.info("=== testDeleteFilter START ===");
        String filterName = generateName();
        String textFilter = generateName();

        logger.info("Удаление фильтра '{}'", filterName);
        LoginPage.login(login, password);
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.clickButtonDeleteFilter();

        Assert.assertFalse(verifyElementVisibleByXPath(
                "//span[text()='%s']", filterName));
        logger.info("Фильтр '{}' успешно удалён.", filterName);
        logger.info("=== testDeleteFilter END ===");
    }

    @Test
    public static void testEditFilter() {
        Logger staticLogger = LogManager.getLogger("EditFilterLogger");
        staticLogger.info("=== testEditFilter START ===");

        String filterName = generateName();
        String textFilter = generateName();
        String newName = generateName();

        staticLogger.info("Редактирование фильтра '{}' → '{}'", filterName, newName);
        LoginPage.login(login, password);
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);
        LaunchesPage.editNameFilter(newName);

        Assert.assertTrue(verifyElementVisibleByXPath(
                "//span[text()='%s']", newName));
        staticLogger.info("Фильтр переименован в '{}'", newName);
        staticLogger.info("=== testEditFilter END ===");
    }
}
