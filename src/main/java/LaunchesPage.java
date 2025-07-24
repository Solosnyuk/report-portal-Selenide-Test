import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LaunchesPage {
        static SelenideElement buttonLaunches =
                $("a[href='#default_personal/launches']");
        static SelenideElement buttonAddFIlter =
                $x("//*[@class='launchFiltersToolbar__add-filter-button--Hgtlm']");
        static SelenideElement textEnterName =
                $("input[placeholder='Enter name']");
        static SelenideElement buttonSaveFilter =
                $x("//span[text()='Save']");
        static SelenideElement textNameNewFilter =
                $x("//input[@type='text' and @placeholder='Enter filter name']");
        static SelenideElement buttonAddFilterSave =
                $x("//button[text()='Add']");
        static SelenideElement buttonUpdateFilterEdit =
                $x("//button[text()='Update']");
        static SelenideElement buttonCloneFilter =
                $x("//button[.//span[text()='Clone']]");
        static SelenideElement buttonDeleteFIlter =  $(
                "path[d='M7 5.727L1.273 0 0 1.273 5.727 7 0 12.727 1.273 14 7 8.273 12.727 14 14 12.727 8.273 7 14 1.273 12.727 0z']");
        static SelenideElement buttonEditFilter = $x("//button[@title='Edit']");

    public static void clickOpenLaunchesPage() {
        buttonLaunches.click();
    }

    public static void clickAddFilter() {
        buttonAddFIlter.click();
    }

    public static void clickButtonSaveFilter() {
        buttonSaveFilter.click();
    }

    public static void clickButtonAddFilterSave() {
        buttonAddFilterSave.click();
    }

    public static void clickCloneFilter() {
        buttonCloneFilter.click();
    }

    public static void clickButtonDeleteFilter() {
        buttonDeleteFIlter.click();
    }

    public static void clickButtonEditFilter() {
        buttonEditFilter.click();
    }

    public static void sendContainsEnterName(String testValue) {
        textEnterName.clear();
        textEnterName.setValue(testValue)   ;
    }

    public static void sendNameNewFilter(String nameFilter) {
        textNameNewFilter.clear();
        textNameNewFilter.setValue(nameFilter);
    }

    public static void clickButtonUpdateFilterEdit() {
        buttonUpdateFilterEdit.click();
    }

    public static void addNewFilter(String nameFilter,String containsText) {
        clickAddFilter();
        sendContainsEnterName(containsText);
        clickButtonSaveFilter();
        sendNameNewFilter(nameFilter);
        clickButtonAddFilterSave();
    }

    public static void editNameFilter(String newFilterName){
        LaunchesPage.clickButtonEditFilter();
        LaunchesPage.sendNameNewFilter(newFilterName);
        LaunchesPage.clickButtonUpdateFilterEdit();
    }
}
