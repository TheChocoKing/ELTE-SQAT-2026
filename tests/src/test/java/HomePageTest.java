import org.junit.*;
import pages.HomePage;
import pages.LoginPage;
import pages.ResultPage;
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

}
