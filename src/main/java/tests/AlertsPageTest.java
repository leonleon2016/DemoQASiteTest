package tests;

import io.qameta.allure.Description;
import org.demoqa.pages.AlertsPage;
import org.demoqa.pages.ElementsPage;
import org.demoqa.pages.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;

public class AlertsPageTest extends BaseTest {

    @Parameters({"alertName"})
    @Test
    @Description(value = "Тест проверяет функционал пункта меню Alerts")
    public void testAlert(String alertName) throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        ElementsPage elementsPage = indexPage.clickElementsLink();
        elementsPage.clickAlertsFramesWindowsButton();
        Thread.sleep(1000);
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
