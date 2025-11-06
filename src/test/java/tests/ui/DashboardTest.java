package tests.ui;

import api.RpConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.page.DashboardsPage;
import ui.page.LoginPage;

import static com.codeborne.selenide.Selenide.screenshot;
import static utils.GenerateName.generateName;

@Epic("UI dashboard test ")
public class DashboardTest extends BaseUiTest {
    private static final Logger logger = LogManager.getLogger(DashboardTest.class);

    @Story("Add new dashboard")
    @Test(groups = "UI", description = "UI dashboard Test")
    public void testAddNewDashboard() {
        logger.info("=== testAddNewDashboard START ===");
        String dashboardName = generateName();
        String descriptionText = generateName();

        logger.info("Добавление новой борды '{}'", dashboardName);

        new LoginPage()
                .login(RpConfig.getConfig().getLogin(), RpConfig.getConfig().getPassword());

        DashboardsPage dashboardsPage = new DashboardsPage();

        dashboardsPage
                .clickOpenDashboardPage()
                .clickOpenNewDashboardSetting()
                .sendNameNewDashboard(dashboardName, descriptionText)
                .clickAddDashboard();

        Assert.assertTrue(dashboardsPage.statusNotifivation(),
                "Уведомление об успешном создании дашборда не отобразилось");
        screenshot("test_success");
    }
}
