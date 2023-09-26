package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChildPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]")
    private WebElement textBoxLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[5]")
    private WebElement buttonsLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]")
    private WebElement browserWindowsLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div")
    private WebElement alertsFramesWindowsButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    private WebElement alertsLink;

    public ChildPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик пункт меню \"Text Box\"")
    public TextBoxPage clickTextBoxLink() {
        textBoxLink.click();
        return new TextBoxPage(driver);
    }

    @Step("Клик пункт меню \"Buttons\"")
    public ButtonsPage clickButtonsLink() {
        buttonsLink.click();
        return new ButtonsPage(driver);
    }

    @Step("Клик пункт меню \"Alerts, Frame & Windows\"")
    public void clickAlertsFramesWindowsButton() {
        this.pointToElementAndClick(alertsFramesWindowsButton);
    }

    @Step("Клик пункт меню \"Browser Windows\"")
    public BrowserWindowsPage clickBrowserWindowsLink() {
        this.pointToElementAndClick(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    @Step("Клик пункт меню \"Alerts\"")
    public AlertsPage clickAlertsPage() {
        alertsLink.click();
        return new AlertsPage(driver);
    }
}
