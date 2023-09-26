package org.demoqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    private WebElement elementsLink;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на категорию \"Elements\"")
    public ElementsPage clickElementsLink() {
        elementsLink.click();
        return new ElementsPage(driver);
    }
}
