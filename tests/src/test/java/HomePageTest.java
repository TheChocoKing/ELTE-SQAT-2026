import org.junit.*;
import pages.HomePage;
import pages.ResultPage;
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

}
