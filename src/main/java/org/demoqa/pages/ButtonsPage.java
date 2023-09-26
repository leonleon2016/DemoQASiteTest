package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends ChildPage {

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на кнопку \"Double Click Me\"")
    public void clickDoubleClickButton() {
        actions.doubleClick(doubleClickButton).perform();
    }

    @Step("Клик на кнопку \"Right Click Me\"")
    public void clickRightClickButton() {
        actions.contextClick(rightClickButton).perform();
    }

    @Step("Клик на кнопку \"Click Me\"")
    public void clickClickMeButton() {
        clickMeButton.click();
    }

    @Step("Проверка появления сообщения после клика на кнопку \"Double Click Me\"")
    public boolean isDoubleClickMessagePresent() {
        return !driver.findElements(By.id("doubleClickMessage")).isEmpty();
    }

    @Step("Проверка появления сообщения после клика на кнопку \"Right Click Me\"")
    public boolean isRightClickMessagePresent() {
        return !driver.findElements(By.id("rightClickMessage")).isEmpty();
    }

    @Step("Проверка появления сообщения после клика на кнопку \"Click Me\"")
    public boolean isClickMeMessagePresent() {
        return !driver.findElements(By.id("dynamicClickMessage")).isEmpty();
    }
}
