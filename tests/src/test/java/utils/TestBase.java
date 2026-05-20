package utils;

import org.openqa.selenium.*;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {

        boolean headless = Boolean.parseBoolean(
                ConfigReader.get("headless")
        );

        driver = DriverFactory.createDriver("chrome", headless);

        driver.get(ConfigReader.get("baseUrl"));

        Cookie cookie = new Cookie("testCookie", "accepted");
        driver.manage().addCookie(cookie);
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}