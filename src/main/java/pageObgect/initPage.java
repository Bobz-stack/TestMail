package pageObgect;

import BaseSelenoid.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class initPage extends BaseClass {
    public initPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@tabindex='10']")
    private WebElement signature;

    @Step("кликаем на кнопку написать")
    public void clickSubmitMail(){
        click("//span[@class='mail-ComposeButton-Text' and contains(., 'Написать')]");
    }

@Step("кликаем на сообщение с темой тестовая тема")
    public void clickLetterSubject(){
        click(".//span[@title='Тестовая тема']");
    }
    @Step("кликаем на письмо с темой Новая темам")
    public void clickNewLetterSubject(){
        click(".//span[@title='Новая тема']");
    }

    @Step("кликаем на входящее письмо ")
    public void clickFirstMessage(){
        click("(//span[contains(., 'Тестовое сообщение')])[5]");
    }
    @Step("кликаем на входящее  с новой темой письмо")
    public void clickNewFirstMessage(){
        click("(//span[contains(., 'Новое сообщение')])[5]");
    }
    @Step("кликаем на кнопку входящие")
    public void clickInboxButton(){
        click("//span[@class='mail-NestedList-Item-Name'and contains(.,'Входящие')]");
    }

    @Step("кликаем на чекбокс сообщения с темой Новая тема")
    public void clickCheckBoxNewTopic(){
        click("(//span[@title='Новая тема']/preceding::span [@class='_nb-checkbox-flag _nb-checkbox-normal-flag'])[1]");
    }

    @Step("кликаем на чекбокс сообщения с темой Тестовая тема")
    public void clickСheckBoxTestTopic(){
        click("(//span[@title='Тестовая тема']/preceding::span [@class='_nb-checkbox-flag _nb-checkbox-normal-flag'])[4]");
    }
    @Step("кликаем на кнопку удалить")
    public void clickButtonDeleted(){
        click("//span [@class='mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']");
    }


            @Step("кликаем на кнопку с настройками")
    public void clickButtonSetting(){
        click("(//button [@data-lego='react' ])[2]");
    }
                    @Step("кликаем на кнопку с основными настройками")
    public void clickBasicsSttings(){
        click("//span[@class='mail-SettingsPopup__menu-item-content' and contains(., 'Личные данные, подпись, портрет')]");
    }
                            @Step("кликаем на кнопку добавить подпись")
    public void clickAddSignature(){
        click("//span[@class='ui-button-text']");
    }
                                    @Step("кликаем на кнопку Почта")
    public void clickReturnToMail(){
        click("(//a[@href='#inbox'])[2]");
    }






    @Step("Вводим подпись в строку с настройками подписи.")
    public void setSignature(String text) {
        setText(signature, text);
    }


}
