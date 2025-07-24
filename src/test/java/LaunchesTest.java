import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchesTest extends BaseUiTest {
    static String login = "default";
    static String password = "1q2w3e";
    static String filterName = generateName();
    static String textFilter = generateName();

    @Test
    public void testAddNewFilter() {
        LoginPage.login(login,password);
        LaunchesPage.clickIfNotLaunchesPage();
        LaunchesPage.addNewFilter(filterName,textFilter);

        Assert.assertTrue(LaunchesPage.getNameFilter(filterName));
    }

}
