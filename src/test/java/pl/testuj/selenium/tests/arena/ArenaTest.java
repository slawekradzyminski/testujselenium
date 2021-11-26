package pl.testuj.selenium.tests.arena;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.testuj.selenium.pages.arena.LoginPage;
import pl.testuj.selenium.tests.AbstractTest;

public class ArenaTest extends AbstractTest {

    @Override
    public String getInitialUrl() {
        return "http://demo.testarena.pl/zaloguj";
    }

    @Test
    public void myFirstSeleniumTest() {
        Assertions.assertThat(driver.getTitle()).contains("TestArena");
    }

    @Test
    public void shouldSuccessfullyLogIn() {
        new LoginPage(driver)
                .successfulLogin("administrator@testarena.pl", "sumXQQ72$L")
                .verifyUserInfoDisplayed();
    }

    @Test
    public void shouldFailToLogIn() {
        new LoginPage(driver)
                .failedLogin("wrong", "wrong")
                .verifyErrorMessageAppeared();
    }

}
