package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import api.RpConfig;
import ui.page.LaunchesPageLocators;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseUiTest {
    protected final LaunchesPageLocators locators = new LaunchesPageLocators();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.headless = true;
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments(
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--disable-gpu",
                        "--window-size=1920,1080",
                        "--remote-allow-origins=*",
                        "--disable-extensions",
                        "--disable-popup-blocking"
                );
        Selenide.open(RpConfig.getConfig().getEndpoint());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    public boolean verifyElementVisibleByXPath(String xpathTemplate, String filterName) {
        try {
            String formattedXPath = String.format(xpathTemplate, filterName);
            $(By.xpath(formattedXPath)).shouldBe(visible, Duration.ofSeconds(5));
            return true;
        } catch (Throwable e) {
            return false;
        }
    }
}
