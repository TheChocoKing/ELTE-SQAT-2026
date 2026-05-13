package tests;

import utils.TestBase;
import org.junit.Assert;
import org.junit.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTests extends TestBase {

    @Test
    public void userCanLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.openLoginPage();

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @Test
    public void userCanLogoutSuccessfully() {

        AccountPage accountPage = new AccountPage(driver);

        accountPage.logout();

        Assert.assertTrue(accountPage.isLoggedOut());
    }
}