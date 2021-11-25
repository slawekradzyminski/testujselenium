package pl.testuj.selenium.tests;

import org.junit.jupiter.api.Test;
import pl.testuj.selenium.pages.HomePage;

public class ArenaPOPTest extends AbstractTest {

    @Override
    public String getInitialUrl() {
        return "http://demo.testarena.pl/zaloguj";
    }

    @Test
    public void myFirstPOPSeleniumTest() {
        HomePage homePage = new HomePage(driver);
        homePage.login();
    }
}
