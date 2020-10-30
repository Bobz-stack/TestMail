package BaseSelenoid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    private WebDriver driver;

    protected final int driverWaitTime = 20;

    public BaseClass(final WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    /**
     * Ждем пока элемент отобразится на странице.
     * Метод возвращает Boolean.
     *
     * @param element
     * @return
     */
    protected Boolean waitVisibilityOfElement(final WebElement element) {
        //   switchToFrame();
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            //          switchToDefaultFrame();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //      switchToDefaultFrame();
        return false;
    }
    /**
     * Метод ждет пока элемент появится на странице.
     * Затем кликает по этому элементу.
     *
     * @param webElement
     */
    protected void click(final WebElement webElement) {

        waitVisibilityOfElement(webElement);

        webElement.click();
    }
    /**
     * Вводит текст в поле webElement.
     *
     * @param webElement
     * @param string
     */
    protected void setText(final WebElement webElement, final String string) {

        waitVisibilityOfElement(webElement);

        webElement.sendKeys(string);

    }
    /**
     * Ждем пока элемент появится в ДОМе.
     * Метод возвращает Boolean.
     *
     * @param xpath
     * @return
     */
    protected Boolean waitPresentOfElement(final String xpath) {
        //   switchToFrame();
        WebDriverWait wait = new WebDriverWait(driver, driverWaitTime);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //          switchToDefaultFrame();
            return true;
        } catch (Exception e) {

        }
        //      switchToDefaultFrame();
        return false;
    }


    /**
     * Метод ждет появления элемента по xpath.
     * Ищет элемент через findElement.
     * Кликает по элементу.
     *
     * @param xpath
     */
    protected void click(final String xpath) {
        waitPresentOfElement(xpath);
        WebElement webElement = getDriver().findElement(By.xpath(xpath));
        waitVisibilityOfElement(webElement);
        // switchToFrame();
        webElement.click();
        //switchToDefaultFrame();
    }

}
