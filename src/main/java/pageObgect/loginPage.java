package pageObgect;

import BaseSelenoid.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BaseClass {
    public loginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement yandexLogin;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement yandexPassword;





    @Step("Вводим логин в строку с логином.")
    public void setYandexLogin(String text) {
        setText(yandexLogin, text);
    }
    @Step("Вводим пароль в строку с паролем.")
    public void setYandexPassword(String text) {
        setText(yandexPassword, text);
    }
    @Step("Кликаем по кнопке  Войти.")
    public void clickSubmitSearch(){
        click("//button[@type='submit' and contains(., 'Войти')]");
    }

}
