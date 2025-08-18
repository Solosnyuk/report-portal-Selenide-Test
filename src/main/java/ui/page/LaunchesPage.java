package ui.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LaunchesPage {
         SelenideElement buttonLaunches =
          $("a[href='#default_personal/launches']");
         SelenideElement buttonAddFIlter =
          $x("//*[@class='launchFiltersToolbar__add-filter-button--Hgtlm']");
         SelenideElement textEnterName =
          $("input[placeholder='Enter name']");
         SelenideElement buttonSaveFilter =
          $x("//span[text()='Save']");
         SelenideElement textNameNewFilter =
          $x("//input[@type='text' and @placeholder='Enter filter name']");
         SelenideElement buttonAddFilterSave =
          $x("//button[text()='Add']");
         SelenideElement buttonUpdateFilterEdit =
          $x("//button[text()='Update']");
         SelenideElement buttonCloneFilter =
          $x("//button[.//span[text()='Clone']]");
         SelenideElement buttonDeleteFIlter =  $x(
          "//div[contains(@class, 'filterItem__icon--zcepO')]");
         SelenideElement buttonEditFilter = $x("//button[@title='Edit']");

    public LaunchesPage clickOpenLaunchesPage() {
        buttonLaunches.click();

        return this;
    }

    public LaunchesPage clickAddFilter() {
        buttonAddFIlter.click();

        return this;
    }

    public LaunchesPage clickButtonSaveFilter() {
        buttonSaveFilter.click();

        return this;
    }

    public LaunchesPage clickButtonAddFilterSave() {
        buttonAddFilterSave.click();

        return this;
    }

    public LaunchesPage clickCloneFilter() {
        buttonCloneFilter.click();

        return this;
    }

    public LaunchesPage clickButtonDeleteFilter() {
        buttonDeleteFIlter.click();

        return this;
    }

    public LaunchesPage clickButtonEditFilter() {
        buttonEditFilter.click();

        return this;
    }

    public LaunchesPage sendContainsEnterName(String testValue) {
        textEnterName.clear();
        textEnterName.setValue(testValue);

        return this;
    }

    public LaunchesPage sendNameNewFilter(String nameFilter) {
        textNameNewFilter.clear();
        textNameNewFilter.setValue(nameFilter);

        return this;
    }

    public LaunchesPage clickButtonUpdateFilterEdit() {
        buttonUpdateFilterEdit.click();

        return this;
    }

    public LaunchesPage addNewFilter(String nameFilter,String containsText) {
        clickAddFilter();
        sendContainsEnterName(containsText);
        clickButtonSaveFilter();
        sendNameNewFilter(nameFilter);
        clickButtonAddFilterSave();
        return this;
    }

    public LaunchesPage editNameFilter(String newFilterName){
        clickButtonEditFilter();
        sendNameNewFilter(newFilterName);
        clickButtonUpdateFilterEdit();

        return this;
    }
}
