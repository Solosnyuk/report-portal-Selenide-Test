package stepdefs;

import io.cucumber.java.Before;
import static com.codeborne.selenide.Selenide.open;
import api.RpConfig;

public class Hooks {

    @Before
    public void setUp() {
        open(RpConfig.getConfig().getEndpoint());
    }
}
