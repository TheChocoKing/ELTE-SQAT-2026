package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;


public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By acceptCookieLocator = By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/button[1]");

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void handleCookiePopup() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieLocator));
            acceptBtn.click();
        } catch (TimeoutException e) {
            // popup did not appear - ignore
        }
    }

    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

}

