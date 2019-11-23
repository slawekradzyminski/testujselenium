package org.vistula.selenium.test.part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class ArenaTest {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void myFirstSeleniumTest() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
        Assertions.assertThat(driver.getTitle()).contains("TestArena");
        driver.quit();
    }

    @Test
    public void myFirstInteractionTest() {
        driver = new ChromeDriver();
        driver.get("http://demo.testarena.pl/zaloguj");
       
        WebElement captcha = driver.findElement(By.id("login"));
        
        captcha.click();
        
        new WebDriverWait(driver, 5, 250)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("login_form_error")));






    }

    @Test
    public void myVistulaUniversityTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.pl");
        WebElement szukajVistula = driver.findElement(By.cssSelector("input[type='text']"));
        szukajVistula.sendKeys("Vistula University");
        szukajVistula.sendKeys(Keys.ENTER);




        driver.quit();
    }

}
