import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LaunchesPage {
        static SelenideElement buttonLaunches = $("a[href='#default_personal/launches']");
        static SelenideElement buttonAddFIlter = $x("//*[@class='launchFiltersToolbar__add-filter-button--Hgtlm']");
        static SelenideElement textEnterName = $("input[placeholder='Enter name']");
        static SelenideElement buttonSaveFilter = $x("//span[text()='Save']");
        static SelenideElement textNameNewFilter = $x("//input[@type='text' and @placeholder='Enter filter name']");
        static SelenideElement buttonAddFilterSave = $x("//button[text()='Add']");
        static SelenideElement filterItem = $("span[class^='filterItem__name']");

    public static void clickIfNotLaunchesPage() {
        buttonLaunches.click();
    }

    public static void clickAddFilter() {
        buttonAddFIlter.click();
    }

    public static void sendContainsEnterName(String testValue) {
        textEnterName.clear();
        textEnterName.setValue(testValue)   ;
    }

    public static void clickButtonSaveFilter() {
        buttonSaveFilter.click();
    }

    public static void sendNameNewFilter(String nameFilter) {
        textNameNewFilter.clear();
        textNameNewFilter.setValue(nameFilter);
    }

    public static void clickButtonAddFilterSave() {
        buttonAddFilterSave.click();
    }

    public static boolean getNameFilter(String filterName) {
        try {
            $x(String.format("//span[text()='%s']", filterName))
                    .shouldBe(visible, Duration.ofSeconds(5));
            return true;
        } catch (Exception e) {
            return false;
        }    }


    public static void addNewFilter(String nameFilter,String containsText) {
        clickAddFilter();
        sendContainsEnterName(containsText);
        clickButtonSaveFilter();
        sendNameNewFilter(nameFilter);
        clickButtonAddFilterSave();
    }
}
