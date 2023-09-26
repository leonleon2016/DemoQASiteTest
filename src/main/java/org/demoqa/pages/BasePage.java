package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    protected WebDriver driver;

    protected Actions actions;

    Wait<WebDriver> driverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void pointToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void pointToElementAndClick(WebElement element) {
        this.pointToElement(element);
        element.click();
    }

    @Step("Сменить вкладку")
    public void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    @Step("Переместить фокус на всплывающее окно")
    public Alert switchToAlert() {
        driverWait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    @Step("Закрыть всплывающее окно")
    public void dismissAlert() {
        driverWait.until(ExpectedConditions.alertIsPresent());
        switchToAlert().dismiss();
    }

    @Step("Принять всплывающее окно")
    public void acceptAlert() {
        driverWait.until(ExpectedConditions.alertIsPresent());
        switchToAlert().accept();
    }

    @Step("Закрыть вкладку")
    public void closeTab() {
        driver.close();
    }
}
