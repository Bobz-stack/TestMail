package TestMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Baze {
    public WebDriver getDriver() {
        return driver;
    }
    WebDriver driver;
    protected String ggrUrl = "http://localhost:4445";

    @BeforeTest
    public void beforeT() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver","C:\\ggr tool\\selenoid\\chromedriver.exe");
        driver = new ChromeDriver(options);
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        int i=32;
        URL hub = null;
        try {
            hub = new URL(ggrUrl + "/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(hub, dc);

        System.out.println("Дейсивие перед тестом");
    }
    @AfterTest
    public void afterT() {
        driver.quit();
        if (driver != null) {
            driver.quit();
        }

        System.out.println("Действие после теста");

    }



}