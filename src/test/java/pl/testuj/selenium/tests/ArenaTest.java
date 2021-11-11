package pl.testuj.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.testuj.selenium.pages.HomePage;

public class ArenaTest {

    private WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openPage() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void myFirstSeleniumTest() {
        Assertions.assertThat(driver.getTitle()).contains("TestArena");
    }

    @Test
    public void myFirstPOPSeleniumTest() {
        HomePage homePage = new HomePage(driver);
        homePage.login();
    }

}
