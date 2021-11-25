package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AwesomeTestingTest extends AbstractTest {

    @BeforeEach
    public void hideCookieInfo() {
        driver.manage().addCookie(new Cookie("displayCookieNotice", "y"));
        driver.navigate().refresh();
    }

    @Override
    String getInitialUrl() {
        return "https://www.awesome-testing.com";
    }

    @Test
    public void shouldDisplayFourPosts() {
        verifyNumberOfPosts(4);
    }

    @Test
    public void shouldSearchForCypress() {
        driver.findElement(By.cssSelector("input.gsc-input")).sendKeys("Cypress");
        driver.findElement(By.cssSelector("input.gsc-search-button")).click();

        waitForResults();
        verifyNumberOfPosts(4);
    }

    @Test
    public void shouldDisplayPostsAssociatedWithLabel() {
        driver.findElement(By.linkText("Cypress")).click();
        waitForResults();
        verifyNumberOfPosts(1);
    }

    private void waitForResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("status-msg-body")));
    }

    private void verifyNumberOfPosts(int numberOfPosts) {
        List<WebElement> posts = driver.findElements(By.className("post-title"));
        Assertions.assertThat(posts).hasSize(numberOfPosts);
    }

}
