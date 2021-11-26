package pl.testuj.selenium.tests.arena;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.testuj.selenium.pages.arena.HomePage;
import pl.testuj.selenium.pages.arena.LoginPage;
import pl.testuj.selenium.tests.AbstractTest;

public class ArenaHomePageTest extends AbstractTest {

    private final String projectName = RandomStringUtils.randomAlphabetic(10);

    // Such login should ideally occur via backend
    @BeforeEach
    public void logIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("administrator@testarena.pl", "sumXQQ72$L");
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
                .verifyNumberOfProjectsFound(1)
                .verifyFirstProjectTitle(projectName);
    }

}
