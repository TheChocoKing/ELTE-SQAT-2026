import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.VehiclePage;
import utils.ConfigReader;
import utils.TestBase;

public class VehiclePageTest extends TestBase {

    @Test
    public void testCommentTextArea() {
        HomePage homePage = new HomePage(this.driver);
        homePage.handleCookiePopup();

        LoginPage loginPage = homePage.openLoginPage();
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        driver.get(ConfigReader.get("baseUrl") + "v002159.html");
        VehiclePage vehiclePage = new VehiclePage(this.driver);
        String comment = "Mean green Mustang machine!";
        vehiclePage.fillCommentTextArea(comment);

        Assert.assertEquals(comment, vehiclePage.getCommentTextAreaContent());
    }
}
