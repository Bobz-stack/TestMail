package TestMail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObgect.initPage;
import pageObgect.loginPage;
import pageObgect.messagePage;

import java.util.concurrent.TimeUnit;

public class TesttingMail extends Baze {
    @Test
    public void sel() throws InterruptedException {

        Assertion a = new Assertion();
        getDriver().get("https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1");
        getDriver().manage().window().maximize();
        initPage in = new initPage(getDriver());
        loginPage lo= new loginPage(getDriver());
        messagePage ms=new messagePage(getDriver());

        lo.setYandexLogin("androsoff.tosha");
        lo.clickSubmitSearch();
        lo.setYandexPassword("q19668733q");
        lo.clickSubmitSearch();

        in.clickSubmitMail();
        Thread.sleep(8000);
        a.assertTrue(findElement(By.xpath("//div[@class='compose-LabelRow' and contains(., 'Кому')]//div[@class='composeYabbles']")));
        ms.setTopicMail("Тестовая тема");
        ms.setRecipientMail("androsoff.tosha@yandex.ru");
        ms.setСontentLetter("Тестовое сообщение");

        ms.clickSendMessage();

        driver.navigate().refresh();
        Thread.sleep(5000);
        a.assertTrue(findElement(By.xpath(".//span[@title='Тестовая тема']")));

        in.clickLetterSubject();

        in.clickFirstMessage();
        Thread.sleep(8000);
        a.assertTrue(findElement(By.xpath("//div[@class='js-message-body-content mail-Message-Body-Content' and contains(., 'Тестовое сообщение')]")) && findElement(By.xpath("//div [@class='mail-Message-Toolbar-Subject mail-Message-Toolbar-Subject_message js-toolbar-subject js-subject-content js-invalid-drag-target' and  contains(., 'Тестовая тема')]")));
        in.clickButtonSetting();
        in.clickBasicsSttings();
        in.setSignature("С уважением," + "\n" + "Андросов Антон" + "\n" + "+79999990102");
        in.clickAddSignature();
        in.clickReturnToMail();
        in.clickSubmitMail();
        Thread.sleep(8000);
        a.assertTrue(findElement(By.xpath("//div[@class='compose-LabelRow' and contains(., 'Кому')]//div[@class='composeYabbles']")) && findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr'and contains(.,'С уважением,')and contains(., 'Андросов Антон')and contains(., '+79999990102')]")));
        ms.setTopicMail("Новая тема");
        ms.setRecipientMail("androsoff.tosha@yandex.ru");
        ms.setСontentLetter("Новое сообщение");
        ms.clickSendMessage();
        Thread.sleep(10000);
        driver.navigate().refresh();
        a.assertTrue(findElement(By.xpath(".//span[@title='Новая тема']")));
        in.clickNewLetterSubject();

        in.clickNewFirstMessage();
        Thread.sleep(8000);
        a.assertTrue(findElement(By.xpath("//div[@class='js-message-body-content mail-Message-Body-Content' and contains(., 'Новое сообщение')]")) && findElement(By.xpath("//div [@class='mail-Message-Toolbar-Subject mail-Message-Toolbar-Subject_message js-toolbar-subject js-subject-content js-invalid-drag-target' and  contains(., 'Новая тема')]")) && findElement(By.xpath("//div[@class='js-message-body-content mail-Message-Body-Content'and contains(.,'С уважением,')and contains(., 'Андросов Антон')and contains(., '+79999990102')]")));
        in.clickInboxButton();
        in.clickCheckBoxNewTopic();
        in.clickСheckBoxTestTopic();
        in.clickButtonDeleted();
        a.assertFalse(findElement(By.xpath(".//span[@title='Новая тема']")) && findElement(By.xpath(".//span[@title='Тестовая тема']")), "Тест прошел успешно");

    }


    private boolean findElement(By locator) {

        try {

            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
