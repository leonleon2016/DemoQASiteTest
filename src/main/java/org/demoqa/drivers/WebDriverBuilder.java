package org.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.demoqa.enums.PlatformName;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverBuilder {
    WebDriver driver;

    public WebDriver setupDriver(String platformName) throws IOException {
        Properties properties = getDriverProperties();
        if (platformName.equalsIgnoreCase(PlatformName.CHROME.name())) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    properties.getProperty("chromeDriver")
            );
            driver = new ChromeDriver();
        } else if (platformName.equalsIgnoreCase(PlatformName.FIREFOX.name())) {
            System.setProperty(
                    "webdriver.gecko.driver",
                    properties.getProperty("firefoxDriver")
            );
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public Properties getDriverProperties() throws IOException {
        Properties properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("config.properties");
        properties.load(inputStream);
        return properties;
    }

}
