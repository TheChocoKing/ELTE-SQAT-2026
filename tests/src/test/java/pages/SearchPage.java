package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends PageBase {

    private final By typeDropdown = By.xpath("//select[@id='inputMovieType']");
    private final By firstRadioButton = By.xpath("(//input[@type='radio'])[1]");

    private final By[] checkBoxButtons = {
            By.xpath("//fieldset//input[@id='checkboxClass1']"),
            By.xpath("//fieldset//input[@id='checkboxClass2']"),
            By.xpath("//fieldset//input[@id='checkboxClass3']")
    };

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstDropdownOption(String optionText) {
        Select dropdown = new Select(this.waitAndReturnElement(typeDropdown));
        dropdown.selectByVisibleText(optionText);
    }

    public String getFirstDropdownSelectedText() {
        Select dropdown = new Select(this.waitAndReturnElement(typeDropdown));
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectFirstRadioButton() {
        this.waitAndReturnElement(firstRadioButton).click();
    }

    public boolean isFirstRadioButtonSelected() {
        return this.waitAndReturnElement(firstRadioButton).isSelected();
    }

    public void selectCheckBoxButtons() {
        for(By checkbox : checkBoxButtons){
            this.waitAndReturnElement(checkbox).click();
        }
    }

    public boolean isCheckBoxButtonsSelected() {
        boolean allSelected = false;
        for(By checkbox : checkBoxButtons){
            allSelected = this.waitAndReturnElement(checkbox).isSelected();
        }
        return allSelected;
    }
}
