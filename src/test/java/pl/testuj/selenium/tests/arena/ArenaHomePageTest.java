package pl.testuj.selenium.tests.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.testuj.selenium.tests.AbstractTest;

import java.util.List;

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

        String projectName = RandomStringUtils.randomAlphabetic(10);

        driver.findElement(By.id("name")).sendKeys(projectName);
        driver.findElement(By.id("prefix")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.id("description")).sendKeys(RandomStringUtils.randomAlphabetic(20));
        driver.findElement(By.id("save")).click();

        driver.findElement(By.cssSelector("[title=Kokpit]")).click();
        driver.findElement(By.cssSelector("[title=Administracja]")).click();
        driver.findElement(By.id("search")).sendKeys(projectName);
        driver.findElement(By.id("j_searchButton")).click();

        List<WebElement> projectsFound = driver.findElements(By.cssSelector("tbody tr"));
        Assertions.assertThat(projectsFound).hasSize(1);

        WebElement firstElementTitle = driver.findElements(By.cssSelector("tbody tr td")).get(0);
        Assertions.assertThat(firstElementTitle.getText()).isEqualTo(projectName);
    }

}
