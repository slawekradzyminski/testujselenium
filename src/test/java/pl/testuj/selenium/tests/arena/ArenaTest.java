package pl.testuj.selenium.tests.arena;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.testuj.selenium.pages.LoginPage;
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
                .login("administrator@testarena.pl", "sumXQQ72$L")
                .verifyUserInfoDisplayed();
    }

    @Test
    public void shouldFailToLogIn() {
        attemptLogin("wrong", "wrong");
        WebElement userInfo = driver.findElement(By.className("login_form_error"));
        Assertions.assertThat(userInfo.isDisplayed()).isTrue();
    }

    private void attemptLogin(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

}
