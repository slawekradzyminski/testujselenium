package pl.testuj.selenium.tests.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.testuj.selenium.tests.AbstractTest;

public class ArenaHomePageTest extends AbstractTest {

    // Such login should ideally occur via backend
    @BeforeEach
    public void logIn() {
        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();
    }

    @Override
    public String getInitialUrl() {
        return "http://demo.testarena.pl/zaloguj";
    }

    @Test
    public void shouldAddProject() {
        driver.findElement(By.cssSelector("[title=Administracja]")).click();
        driver.findElements(By.className("button_link")).get(0).click();

        driver.findElement(By.id("name")).sendKeys(RandomStringUtils.randomAlphabetic(10));
        driver.findElement(By.id("prefix")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.id("description")).sendKeys(RandomStringUtils.randomAlphabetic(20));
        driver.findElement(By.id("save")).click();
    }

}
