package org.vistula.selenium.test.part1;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArenaTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void myFirstSeleniumTest() {
        driver.get("http://demo.testarena.pl/zaloguj");
        Assertions.assertThat(driver.getTitle()).contains("TestArena");
    }

    @Test
    public void myFirstInteractionTest() {
        driver.get("http://demo.testarena.pl/zaloguj");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login"));

        email.sendKeys("administrator@testarena.pl");
        password.sendKeys("sumXQQ72$L");
        login.click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("footer")));

        Assertions.assertThat(driver.getTitle()).contains("Kokpit");
    }

}
