package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    private final By usernameInput = By.id("inputU");

    private final By passwordInput = By.id("inputP");

    private final By submitButton = By.xpath("//div[@id='Login']//input[@type='submit']");

    private final By logoutButton = By.xpath("//ul[@id='UserLinks']//a[@href='logout.php']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {

        this.waitAndReturnElement(usernameInput).sendKeys(username);
        this.waitAndReturnElement(passwordInput).sendKeys(password);
        this.waitAndReturnElement(submitButton).click();
    }

    public void logout() {
        this.waitAndReturnElement(logoutButton).click();
    }
}
