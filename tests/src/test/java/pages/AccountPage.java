package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends PageBase {

    private final By accountMenu = By.xpath(
            "//a[contains(@href,'account')]"
    );

    private final By logoutButton = By.xpath(
            "//a[contains(@href,'logout')]"
    );

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {

        driver.findElement(accountMenu).click();
        driver.findElement(logoutButton).click();
    }

    public boolean isLoggedOut() {
        return driver.getCurrentUrl().contains("logout");
    }
}