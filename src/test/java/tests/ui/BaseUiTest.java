package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import api.RpConfig;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseUiTest {

    @BeforeMethod
    public void setUp() {
        Configuration.headless = true;
        open(RpConfig.getURL("rp.baseURL"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    public static boolean verifyElementVisibleByXPath(String xpathTemplate, String filterName) {
        try {
            String formattedXPath = String.format(xpathTemplate, filterName);
            $(By.xpath(formattedXPath)).shouldBe(visible, Duration.ofSeconds(5));
            return true;
        } catch (Throwable e) {
            return false;
        }
    }
}
