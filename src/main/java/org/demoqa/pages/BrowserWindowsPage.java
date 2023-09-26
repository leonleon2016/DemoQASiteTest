package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends ChildPage {

    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на кнопку \"New Tab\"")
    public void clickNewTabButton() {
        newTabButton.click();
    }

    @Step("Клик на кнопку \"New Window\"")
    public void clickNewWindowButton() {
        this.pointToElementAndClick(newWindowButton);
    }

}
