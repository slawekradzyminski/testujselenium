package pl.testuj.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openPage() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get(getInitialUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public abstract String getInitialUrl();
}
