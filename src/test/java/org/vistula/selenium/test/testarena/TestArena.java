package org.vistula.selenium.test.testarena;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;
import org.junit.Test;


import static org.junit. Assert.assertEquals;

public class TestArena {

    private WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup () {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    @Test
    public void loginTest() throws InterruptedException {


        driver.findElement(By.name("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.name("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("save")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("icon_tools")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("button_link")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("name")).sendKeys("nowy projekt1");
        driver.findElement(By.name("prefix")).sendKeys("100");
        driver.findElement(By.id("save")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("activeMenu")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("search")).sendKeys("nowy projekt1");
        driver.findElement(By.id("j_searchButton")).click();


    }

    @After
    public void quit () {

        driver.quit();


    }

}
