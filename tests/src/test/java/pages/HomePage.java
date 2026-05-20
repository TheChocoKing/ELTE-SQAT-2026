package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    private final By bodyLocator = By.tagName("body");
    private final By searchLocator = By.xpath("//form[@id='Qsearch']//input[@type='text']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchLocator).click();
        this.waitAndReturnElement(searchLocator).sendKeys(searchQuery, Keys.ENTER);
        return new ResultPage(this.driver);
    }

}