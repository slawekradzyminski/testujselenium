package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.testuj.selenium.pages.awesome.AwesomeTestingHomePage;

import java.util.List;

public class AwesomeTestingTest extends AbstractTest {

    @BeforeEach
    public void hideCookieInfo() {
        driver.manage().addCookie(new Cookie("displayCookieNotice", "y"));
        driver.navigate().refresh();
    }

    @Override
    public String getInitialUrl() {
        return "https://www.awesome-testing.com";
    }

    @Test
    public void shouldDisplayFourPosts() {
        new AwesomeTestingHomePage(driver)
                .verifyNumberOfPosts(4);
    }

    @Test
    public void shouldDisplayFiveRecommendedPosts() {
        new AwesomeTestingHomePage(driver)
                .verifyNumberOfRecommendedPosts(5);
    }

    @Test
    public void shouldSearchForCypress() {
        new AwesomeTestingHomePage(driver)
                .search("Cypress")
                .waitForResults()
                .verifyNumberOfPosts(4);
    }

    @Test
    public void shouldDisplayPostsAssociatedWithLabel() {
        new AwesomeTestingHomePage(driver)
                .clickLabel("Cypress")
                .waitForResults()
                .verifyNumberOfPosts(1);
    }

    @Test
    public void shouldDisplayAddCommentSection() {
        driver.findElements(By.className("post-title")).get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("blogger-comment-from-post")));
    }

    // https://stackoverflow.com/questions/9588827/how-to-switch-to-the-new-browser-window-which-opens-after-click-on-the-button
    @Test
    public void shouldCorrectlyOpenGitHub() {
        driver.findElements(By.cssSelector(".HTML a img")).get(3).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String mainWindowHandle = driver.getWindowHandle();
        String newlyOpenedWindowHandle = driver.getWindowHandles().stream()
                .filter(id -> !id.equals(mainWindowHandle))
                .findFirst().get();

        driver.switchTo().window(newlyOpenedWindowHandle);
        Assertions.assertThat(driver.getTitle()).contains("GitHub");
        driver.switchTo().window(mainWindowHandle);
        Assertions.assertThat(driver.getTitle()).contains("Awesome Testing");
    }

}
