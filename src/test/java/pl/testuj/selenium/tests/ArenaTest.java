package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArenaTest extends AbstractTest {

    @Override
    String getInitialUrl() {
        return "http://demo.testarena.pl/zaloguj";
    }

    @Test
    public void myFirstSeleniumTest() {
        Assertions.assertThat(driver.getTitle()).contains("TestArena");
    }

}
