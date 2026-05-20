import org.junit.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ResultPage;
import pages.SearchPage;
import pages.VehiclePage;
import utils.ConfigReader;
import utils.TestBase;


public class HomePageTest extends TestBase {

    @Test
    public void testSearchBar() {
        HomePage homePage = new HomePage(this.driver);
        homePage.handleCookiePopup();
        Assert.assertTrue(homePage.getBodyText().contains("Welcome to IMCDb.org"));

        ResultPage resultPage = homePage.search("gone in 60 seconds");
        String bodyText = resultPage.getBodyText();
        Assert.assertTrue(bodyText.contains("Gone in 60 Seconds"));
    }

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(this.driver);
        homePage.handleCookiePopup();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        String bodyText = homePage.getBodyText();
        Assert.assertTrue(bodyText.contains("Profile"));
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(this.driver);
        homePage.handleCookiePopup();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        loginPage.logout();
        String bodyText = homePage.getBodyText();
        Assert.assertTrue(bodyText.contains("Login"));
    }

    @Test
    public void testMultiplePages() {
        String[][] pages = {
                {ConfigReader.get("baseUrl"), "Welcome to IMCDb.org"},
                {ConfigReader.get("baseUrl") + "search.php", "Search for a movie or a TV series"},
                {ConfigReader.get("baseUrl") + "help.php", "Help/FAQ"},
                {ConfigReader.get("baseUrl") + "stats.php", "Statistics"},
                {ConfigReader.get("baseUrl") + "links.php", "Links"}
        };

        HomePage homePage = new HomePage(this.driver);

        for (String[] page : pages) {
            driver.get(page[0]);
            homePage.handleCookiePopup();
            Assert.assertTrue(homePage.getBodyText().contains(page[1]));
        }
    }

    @Test
    public void testPageTitle() {
        HomePage homePage = new HomePage(this.driver);
        homePage.handleCookiePopup();

        Assert.assertEquals("IMCDb.org: Cars, bikes, trucks and other vehicles seen in movies and TV series", driver.getTitle());
    }

}
