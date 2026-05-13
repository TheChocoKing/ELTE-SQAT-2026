package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PageBase;

public class HomePage extends PageBase {

    private final By forumsMenu = By.xpath(
            "//span[contains(text(),'Forums')]"
    );

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLoaded() {
        return driver.getTitle().contains("overtake");
    }

    public void openForums() {
        driver.findElement(forumsMenu).click();
    }
}