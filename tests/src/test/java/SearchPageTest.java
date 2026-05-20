import org.junit.Assert;
import org.junit.Test;
import pages.SearchPage;
import utils.ConfigReader;
import utils.TestBase;

public class SearchPageTest extends TestBase {

    @Test
    public void testDropdown() {
        driver.get(ConfigReader.get("baseUrl") + "search.php");
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.handleCookiePopup();

        searchPage.selectFirstDropdownOption("TV Series");

        Assert.assertEquals("TV Series", searchPage.getFirstDropdownSelectedText());
    }

    @Test
    public void testRadioButton() {
        driver.get(ConfigReader.get("baseUrl") + "search.php");
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.handleCookiePopup();

        searchPage.selectFirstRadioButton();

        Assert.assertTrue(searchPage.isFirstRadioButtonSelected());
    }

    @Test
    public void testCheckboxButton() {
        driver.get(ConfigReader.get("baseUrl") + "search.php");
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.handleCookiePopup();

        searchPage.selectCheckBoxButtons();
        Assert.assertTrue(searchPage.isCheckBoxButtonsSelected());
    }
}
