package org.vistula.selenium.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class PostPage extends PageObject {

    @FindBy(id = "comment-editor")
    private WebElement commentsSection;

    public PostPage(WebDriver driver) {
        super(driver);
    }

    public PostPage isInitialized() {
        Assertions.assertThat(commentsSection.isDisplayed()).isTrue();
        return this;
    }

    public void assertThatCommentSectionIsDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("comments")));
    }

    private Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .withMessage("Oops, element didn't appear!");

}