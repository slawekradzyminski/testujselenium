package pl.testuj.selenium.tests.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        new HomePage(driver)
                .openAdministrationPanel()
                .clickAddNewProject()
                .addProject(projectName)
                .openCockpit()
                .openAdministrationPanel()
                .searchByProjectName(projectName)
                .verifyNumberOfProjectsFound(2)
                .verifyFirstProjectTitle(projectName);
    }

}
