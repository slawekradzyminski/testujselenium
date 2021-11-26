package pl.testuj.selenium.pages.awesome;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AwesomeTestingHomePage {

    @FindBy(className = "post-title")
    private List<WebElement> posts;

    @FindBy(css = ".popular-posts li")
    private List<WebElement> popularPosts;

    @FindBy(css = "input.gsc-input")
    private WebElement searchField;

    @FindBy(css = "input.gsc-search-button")
    private WebElement searchButton;

    @FindBy(className = "post-title")
    private List<WebElement> postTitles;

    @FindBy(css = ".HTML a img")
    private List<WebElement> socialIcons;

    private final WebDriver driver;

    public AwesomeTestingHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyNumberOfPosts(int numberOfPosts) {
        Assertions.assertThat(posts).hasSize(numberOfPosts);
    }

    public void verifyNumberOfRecommendedPosts(int numberOfRecommendedPosts) {
        Assertions.assertThat(popularPosts).hasSize(numberOfRecommendedPosts);
    }

    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public LabelPage clickLabel(String label) {
        driver.findElement(By.linkText(label)).click();
        return new LabelPage(driver);
    }

    public PostPage openFirstPost() {
        postTitles.get(0).click();
        return new PostPage(driver);
    }

    public void clickGithubLink() {
        socialIcons.get(3).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
