package tests;

import io.qameta.allure.Description;
import org.demoqa.pages.BrowserWindowsPage;
import org.demoqa.pages.ElementsPage;
import org.demoqa.pages.IndexPage;
import org.testng.annotations.Test;

public class BrowserWindowsPageTest extends BaseTest {

    @Test
    @Description(value = "Тест проверяет функционал кнопки \"New Tab\"")
    public void testNewTabButton() throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        ElementsPage elementsPage = indexPage.clickElementsLink();
        elementsPage.clickAlertsFramesWindowsButton();
        Thread.sleep(1000);
        BrowserWindowsPage browserWindowsPage = elementsPage.clickBrowserWindowsLink();
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.switchToTab(1);
        browserWindowsPage.closeTab();
        browserWindowsPage.switchToTab(0);
    }

    @Test
    @Description(value = "Тест проверяет функционал кнопки \"New Window\"")
    public void testNewWindowButton() throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        ElementsPage elementsPage = indexPage.clickElementsLink();
        elementsPage.clickAlertsFramesWindowsButton();
        Thread.sleep(1000);
        BrowserWindowsPage browserWindowsPage = elementsPage.clickBrowserWindowsLink();
        browserWindowsPage.clickNewWindowButton();
        browserWindowsPage.switchToTab(1);
        browserWindowsPage.closeTab();
    }
}
