package ui.page;

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
        static SelenideElement buttonDeleteFIlter =  $x(
                "//div[contains(@class, 'filterItem__icon--zcepO')]");
        static SelenideElement buttonEditFilter = $x("//button[@title='Edit']");

    public void clickOpenLaunchesPage() {
        buttonLaunches.click();
    }

    public static void clickAddFilter() {
        buttonAddFIlter.click();
    }

    public void clickButtonSaveFilter() {
        buttonSaveFilter.click();
    }

    public void clickButtonAddFilterSave() {
        buttonAddFilterSave.click();
    }

    public void clickCloneFilter() {
        buttonCloneFilter.click();
    }

    public void clickButtonDeleteFilter() {
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

    public void addNewFilter(String nameFilter,String containsText) {
        clickAddFilter();
        sendContainsEnterName(containsText);
        clickButtonSaveFilter();
        sendNameNewFilter(nameFilter);
        clickButtonAddFilterSave();
    }

    public void editNameFilter(String newFilterName){
        LaunchesPage.clickButtonEditFilter();
        LaunchesPage.sendNameNewFilter(newFilterName);
        LaunchesPage.clickButtonUpdateFilterEdit();
    }
}
