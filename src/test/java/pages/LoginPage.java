package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageBase;

public class LoginPage extends PageBase {

    private final By loginButton = By.xpath(
            "//a[contains(@href,'login')]"
    );

    private final By usernameInput = By.name("login");

    private final By passwordInput = By.name("password");

    private final By submitButton = By.xpath(
            "//button[contains(@class,'button--primary')]"
    );

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {

        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}