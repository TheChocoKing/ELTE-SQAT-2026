package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory  {

    public static WebDriver createDriver(String browser, boolean headless) throws MalformedURLException {

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            //options.addArguments("--no-sandbox");
            //options.addArguments("--disable-dev-shm-usage");

            if (headless) {
                options.addArguments("--headless");
            }

            return new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        }

        throw new IllegalArgumentException(
                "Unsupported browser: " + browser
        );
    }
}