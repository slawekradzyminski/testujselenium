package pl.testuj.selenium.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DuckDuckGoTest extends AbstractTest {

    @Override
    public String getInitialUrl() {
        return "https://www.duckduckgo.com";
    }

    @Test
    public void shouldOpenDuckDuckGo() {
        driver.manage().window().maximize();
        Assertions.assertThat(driver.getTitle()).contains("DuckDuckGo");
        Assertions.assertThat(driver.getCurrentUrl()).contains("duckduckgo");
    }

    @Test
    public void shouldFindEclipseInDuckDuckGo() {
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Eclipse Group UK");
        driver.findElement(By.id("search_button_homepage")).click();
        WebElement linkToEclipse = driver.findElement(By.cssSelector("[href='https://www.eclipsegroup.co.uk/']"));
        Assertions.assertThat(linkToEclipse.isDisplayed()).isTrue();
    }

}
