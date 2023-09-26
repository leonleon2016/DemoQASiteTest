package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends ChildPage {

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "promtButton")
    private WebElement promptButton;

    @FindBy(id = "promptResult")
    private WebElement promptResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на кнопку всплывающего окна")
    public void clickAlertButton() {
        alertButton.click();
    }

    @Step("Клик на кнопку всплывающего окна с таймером")
    public void clickTimerAlertButton() {
        timerAlertButton.click();
    }

    @Step("Клик на кнопку всплывающего окна с подтверждением")
    public void clickConfirmButton() {
        confirmButton.click();
    }

    @Step("Проверка появления сообщения после клика на кнопку подтверждения")
    public boolean isConfirmResultPresent() {
        return !driver.findElements(By.id("confirmResult")).isEmpty();
    }

    public String getPromptResult() {
        return promptResult.getText();
    }

    @Step("Клик на кнопку всплывающего окна с текстовым полем")
    public void clickPromptButton() {
        promptButton.click();
    }

}
