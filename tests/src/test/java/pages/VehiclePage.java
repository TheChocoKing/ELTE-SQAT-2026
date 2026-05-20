package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehiclePage extends PageBase {

    private final By commentTextArea = By.xpath("//textarea");

    public VehiclePage(WebDriver driver) {
        super(driver);
    }

    public void fillCommentTextArea(String comment) {
        this.waitAndReturnElement(commentTextArea).sendKeys(comment);
    }

    public String getCommentTextAreaContent() {
        return this.waitAndReturnElement(commentTextArea).getAttribute("value");
    }
}
