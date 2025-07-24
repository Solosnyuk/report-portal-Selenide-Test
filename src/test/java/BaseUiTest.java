import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseUiTest {
    String baseURL = "https://demo.reportportal.io";

    @BeforeMethod
    public void setUp() {
        Configuration.headless = true;
        open(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    public static String generateName() {
        Random random = new Random();
        return "filter_" + ('a' + random.nextInt(26)) + random.nextInt(1000);

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
