package ui.page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardsPage {
    SelenideElement buttonDashboards =
            $x("//a[@href=\"#default_personal/dashboard\"]");
    SelenideElement buttonAddNewDashboard =
            $x("//span[text()='Add New Dashboard']");
    SelenideElement nameDashboardInNewDashboard =
            $x("//input[@class=\"input__input--iYEmM type-text variant-standard input__error--qY4dY\"]");
    SelenideElement descroptionNewInDashboard =
            $x("//textarea[@class=\"inputTextArea__input-text-area--N0goa\"]");
    SelenideElement buttonAddDashboard =
            $x("//button[text()='Add']");
    SelenideElement nottificationList =
            $x("//div[@data-automation-id=\"notificationsContainer\"]");

    public DashboardsPage clickOpenDashboardPage() {
        buttonDashboards.click();

        return this;
    }

    public DashboardsPage clickOpenNewDashboardSetting() {
        buttonAddNewDashboard.click();

        return this;
    }

    public DashboardsPage sendNameNewDashboard(String nameDashboard, String descriptionDashboard) {
        nameDashboardInNewDashboard.clear();
        nameDashboardInNewDashboard.setValue(nameDashboard);
        descroptionNewInDashboard.clear();
        descroptionNewInDashboard.setValue(descriptionDashboard);

        return this;
    }

    public DashboardsPage clickAddDashboard() {
        buttonAddDashboard.click();

        return this;
    }

    public boolean statusNotifivation() {
        try {
            nottificationList.shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
