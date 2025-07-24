import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchesTest extends BaseUiTest {
    String login = "default";
    String password = "1q2w3e";

    @Test
    public void testAddNewFilter() {
        String filterName = generateName();
        String textFilter = generateName();

        LoginPage.login(login, password);
        LaunchesPage.clickOpenLaunchesPage();
        LaunchesPage.addNewFilter(filterName, textFilter);

        Assert.assertTrue(verifyElementVisibleByXPath(
                "//span[text()='%s']",filterName));
    }

     @Test
     public void testCloneFilter() {
         String filterName = generateName();
         String textFilter = generateName();

         LoginPage.login(login,password);
         LaunchesPage.clickOpenLaunchesPage();
         LaunchesPage.addNewFilter(filterName,textFilter);
         LaunchesPage.clickCloneFilter();
         LaunchesPage.clickButtonSaveFilter();
         LaunchesPage.clickButtonAddFilterSave();

         Assert.assertTrue(verifyElementVisibleByXPath(
                 "//span[text()='%s']","Copy " + filterName));
     }

     @Test
     public void testDeleteFilter() {
         String filterName = generateName();
         String textFilter = generateName();

         LoginPage.login(login, password);
         LaunchesPage.clickOpenLaunchesPage();
         LaunchesPage.addNewFilter(filterName, textFilter);
         LaunchesPage.clickButtonDeleteFilter();

         Assert.assertFalse(verifyElementVisibleByXPath(
                 "//span[text()='%s']",filterName));
     }
}
