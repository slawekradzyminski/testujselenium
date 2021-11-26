package pl.testuj.selenium.tests.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.testuj.selenium.pages.AddNewProjectPage;
import pl.testuj.selenium.pages.AdministrationPage;
import pl.testuj.selenium.pages.HomePage;
import pl.testuj.selenium.pages.LoginPage;
import pl.testuj.selenium.tests.AbstractTest;

import java.util.List;

public class ArenaHomePageTest extends AbstractTest {

    private final String projectName = RandomStringUtils.randomAlphabetic(10);

    // Such login should ideally occur via backend
    @BeforeEach
    public void logIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("administrator@testarena.pl", "sumXQQ72$L");
    }

    @Override
    public String getInitialUrl() {
        return "http://demo.testarena.pl/zaloguj";
    }

    @Test
    public void shouldAddProject() {
        HomePage homePage = new HomePage(driver);
        homePage.openAdministrationPanel()
                .clickAddNewProject()
                .addProject(projectName);

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
