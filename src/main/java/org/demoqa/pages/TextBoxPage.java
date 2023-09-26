package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TextBoxPage extends ChildPage {

    @FindBy(id = "userName")
    private WebElement nameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "name")
    private WebElement nameOutput;

    @FindBy(id = "email")
    private WebElement emailOutput;

    @FindBy(css = "p#currentAddress.mb-1")
    private WebElement currentAddressOutput;

    @FindBy(css = "p#permanentAddress.mb-1")
    private WebElement permanentAddressOutput;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение формы")
    public void sendCredentials(
            String fullName,
            String email,
            String currentAddress,
            String permanentAddress
    ) {
        setNameInput(fullName);
        setEmailInput(email);
        setCurrentAddressInput(currentAddress);
        setPermanentAddressInput(permanentAddress);
        clickSubmitButton();
    }

    @Step("Заполнение поля \"Full Name\"")
    public void setNameInput(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Заполнение поля \"Email\"")
    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Заполнение поля \"Current Address\"")
    public void setCurrentAddressInput(String currentAddress) {
        currentAddressInput.sendKeys(currentAddress);
    }

    @Step("Заполнение поля \"Permanent Address\"")
    public void setPermanentAddressInput(String permanentAddress) {
        permanentAddressInput.sendKeys(permanentAddress);
    }

    @Step("Клик на кнопку \"Submit\"")
    public void clickSubmitButton() {
        this.pointToElementAndClick(submitButton);
    }

    @Step("Проверка на появление данных после заполнения формы")
    public boolean isTextBoxOutPutExists() {
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions
                        .presenceOfElementLocated(
                                By.cssSelector("#output > div")));
        return element.isDisplayed();
    }

    public String getNameOutput() {
        return nameOutput.getText();
    }

    public String getEmailOuput() {
        return emailOutput.getText();
    }

    public String getCurrentAddressOuput() {
        return currentAddressOutput.getText();
    }

    public String getPermanentAddressOuput() {
        return permanentAddressOutput.getText();
    }

}
