package pageObgect;

import BaseSelenoid.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class messagePage extends BaseClass {
    public messagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='compose-LabelRow' and contains(., 'Кому')]//div[@class='composeYabbles']")
    private WebElement recipientMail;

    @FindBy(xpath = "//input[@class='composeTextField ComposeSubject-TextField']")
    private WebElement topicMail;
    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']")
    private WebElement contentLetter;

    @Step("Вводим емайл в строку с получателем.")
    public void setRecipientMail(String text) {
        setText(recipientMail, text);
    }
    @Step("Вводим тему в строку с темой.")
    public void setTopicMail(String text) {
        setText(topicMail, text);
    }
    @Step("Вводим содеражние в строку с содержанием письма.")
    public void setСontentLetter(String text) {
        setText(contentLetter, text);
    }

    @Step("кликаем на кнопку отправить")
    public void clickSendMessage(){
        click("//button[@type='button' and contains(., 'Отправить')]");
    }
}
