package tests;

import org.demoqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import static io.qameta.allure.Allure.step;

public class OverallTest extends BaseTest {

    @Parameters({"userName", "userEmail", "userCurrentAddress", "userPermanentAddress", "alertName"})
    @Test
    @Description(value = "Тест проверяет функционал следующих пунктов меню: Text box, Buttons, Browser Windows, Alerts")
    public void testAll(
            String userName,
            String userEmail,
            String userCurrentAddress,
            String userPermanentAddress,
            String alertName
    ) throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        ElementsPage elementsPage = indexPage.clickElementsLink();
        TextBoxPage textBoxPage = elementsPage.clickTextBoxLink();
        textBoxPage.sendCredentials(
                userName,
                userEmail,
                userCurrentAddress,
                userPermanentAddress
        );
        Assert.assertTrue(textBoxPage.isTextBoxOutPutExists());
        String nameOutput = textBoxPage.getNameOutput();
        String emailOutput = textBoxPage.getEmailOuput();
        String currentAddressOutput = textBoxPage.getCurrentAddressOuput();
        String permanentAddressOutput = textBoxPage.getPermanentAddressOuput();
        step("Проверка имени пользователя");
        Assert.assertEquals(nameOutput.split(":")[1], userName);
        step("Проверка электронной почты пользователя");
        Assert.assertEquals(emailOutput.split(":")[1], userEmail);
        step("Проверка текущего адреса пользователя");
        Assert.assertEquals(currentAddressOutput.split(":")[1], userCurrentAddress);
        step("Проверка постоянного адреса пользователя");
        Assert.assertEquals(permanentAddressOutput.split(":")[1], userPermanentAddress);


        ButtonsPage buttonsPage = elementsPage.clickButtonsLink();
        buttonsPage.clickDoubleClickButton();
        buttonsPage.clickRightClickButton();
        buttonsPage.clickClickMeButton();
        Assert.assertTrue(buttonsPage.isDoubleClickMessagePresent());
        Assert.assertTrue(buttonsPage.isRightClickMessagePresent());
        Assert.assertTrue(buttonsPage.isClickMeMessagePresent());
        elementsPage.clickAlertsFramesWindowsButton();
        Thread.sleep(1000);
        BrowserWindowsPage browserWindowsPage = elementsPage.clickBrowserWindowsLink();
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.switchToTab(1);
        browserWindowsPage.closeTab();
        browserWindowsPage.switchToTab(0);
        browserWindowsPage.clickNewWindowButton();
        browserWindowsPage.switchToTab(1);
        browserWindowsPage.closeTab();
        browserWindowsPage.switchToTab(0);
        AlertsPage alertsPage = elementsPage.clickAlertsPage();
        alertsPage.clickAlertButton();
        alertsPage.dismissAlert();
        alertsPage.clickTimerAlertButton();
        alertsPage.dismissAlert();
        alertsPage.clickConfirmButton();
        alertsPage.acceptAlert();
        Assert.assertTrue(alertsPage.isConfirmResultPresent());
        alertsPage.clickPromptButton();
        alertsPage.switchToAlert().sendKeys(alertName);
        alertsPage.acceptAlert();
        step("Проверка данных всплывающего окна");
        Assert.assertEquals("You entered " + alertName, alertsPage.getPromptResult());
    }
}
