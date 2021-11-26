package pl.testuj.selenium.pages.awesome;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testuj.selenium.tests.AwesomeTestingTest;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    @FindBy(className = "post-title")
    private List<WebElement> posts;

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage waitForResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("status-msg-body")));
        return this;
    }

    public void verifyNumberOfPosts(int postCount) {
        Assertions.assertThat(posts).hasSize(postCount);
    }
}
