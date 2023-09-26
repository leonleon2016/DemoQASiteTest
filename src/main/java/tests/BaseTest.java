package tests;

import org.demoqa.enums.PlatformType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.demoqa.drivers.WebDriverBuilder;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    @Parameters({"platformType", "platformName", "url"})
    @BeforeMethod
    public void setupDriver(String platformType, String platformName, String url) throws IOException {
        if (platformType.equalsIgnoreCase(PlatformType.WEB.toString())) {
            setupWebDriver(platformName, url);
        }
    }

    public void setupWebDriver(String platformName, String url) throws IOException {
        driver = new WebDriverBuilder().setupDriver(platformName);
        driver.get(url);
    }
}
