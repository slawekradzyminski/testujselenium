package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pl.testuj.selenium.pages.awesome.AwesomeTestingHomePage;

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
        new AwesomeTestingHomePage(driver)
                .openFirstPost()
                .waitForCommentSectionLoad();
    }

    // https://stackoverflow.com/questions/9588827/how-to-switch-to-the-new-browser-window-which-opens-after-click-on-the-button
    @Test
    public void shouldCorrectlyOpenGitHub() {
        new AwesomeTestingHomePage(driver)
                .clickGithubLink();

        String mainWindowHandle = driver.getWindowHandle();
        String newlyOpenedWindowHandle = getGithubWindowHandle(mainWindowHandle);

        assertTitle(newlyOpenedWindowHandle, "GitHub");
        assertTitle(mainWindowHandle, "Awesome Testing");
    }

    private void assertTitle(String windowHandle, String title) {
        driver.switchTo().window(windowHandle);
        Assertions.assertThat(driver.getTitle()).contains(title);
    }

    private String getGithubWindowHandle(String mainWindowHandle) {
        return driver.getWindowHandles().stream()
                .filter(id -> !id.equals(mainWindowHandle))
                .findFirst().get();
    }

}
