package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.demoqa.pages.ElementsPage;
import org.demoqa.pages.IndexPage;
import org.demoqa.pages.TextBoxPage;
import static io.qameta.allure.Allure.step;

public class TextBoxPageTest extends BaseTest {

    @Parameters({"userName", "userEmail", "userCurrentAddress", "userPermanentAddress"})
    @Test
    @Description(value = "Тест проверяет функционал пункта меню Text Box")
    public void testUserForm(
            String userName,
            String userEmail,
            String userCurrentAddress,
            String userPermanentAddress
    ) {
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
    }
}
