package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BingTest extends AbstractTest {

    @Override
    String getInitialUrl() {
        return "https://www.bing.com";
    }

    @Test
    public void shouldFindEclipseInBing() {
        search("Eclipse Group UK");
        WebElement linkToEclipse = driver.findElement(By.cssSelector("[href='https://www.eclipsegroup.co.uk/']"));
        Assertions.assertThat(linkToEclipse.isDisplayed()).isTrue();
    }

    @Test
    public void shouldDisplayAtLeastFourResults() {
        search("Eclipse Group UK");
        List<WebElement> results = driver.findElements(By.cssSelector("li.b_algo"));
        Assertions.assertThat(results).hasSizeGreaterThanOrEqualTo(4);
    }

    private void search(String searchTerm) {
        driver.findElement(By.id("sb_form_q")).sendKeys(searchTerm);
        driver.findElement(By.id("search_icon")).click();
    }

}
