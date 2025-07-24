import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class BaseUiTest {
    String baseURL = "https://demo.reportportal.io";

    @BeforeMethod
    public void setUp() {
        open(baseURL);
    }

    public static String generateName() {
        Random random = new Random();
        return "filter_" + ('a' + random.nextInt(26)) + random.nextInt(1000);

    }

}
