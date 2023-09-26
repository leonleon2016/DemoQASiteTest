package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.demoqa.pages.ButtonsPage;
import org.demoqa.pages.ElementsPage;
import org.demoqa.pages.IndexPage;

public class ButtonsPageTest extends BaseTest {

    @Test
    @Description(value = "Тест проверяет функционал пункта меню Buttons")
    public void testButtons() {
        IndexPage indexPage = new IndexPage(driver);
        ElementsPage elementsPage = indexPage.clickElementsLink();
        ButtonsPage buttonsPage = elementsPage.clickButtonsLink();
        buttonsPage.clickDoubleClickButton();
        buttonsPage.clickRightClickButton();
        buttonsPage.clickClickMeButton();
        Assert.assertTrue(buttonsPage.isDoubleClickMessagePresent());
        Assert.assertTrue(buttonsPage.isRightClickMessagePresent());
        Assert.assertTrue(buttonsPage.isClickMeMessagePresent());
    }
}
